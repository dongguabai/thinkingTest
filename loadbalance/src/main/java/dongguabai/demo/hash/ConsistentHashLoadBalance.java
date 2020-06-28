package dongguabai.demo.hash;

import com.google.common.collect.Multiset;
import dongguabai.demo.AbstractLoadBalance;
import dongguabai.demo.Invoker;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.IntStream;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2020-06-27 21:38
 */
public class ConsistentHashLoadBalance extends AbstractLoadBalance {

    /**
     * 虚拟节点数量
     */
    private static final int VIRTUAL_NODE_NUM = 1000;

    /**
     * hash 和 虚拟节点映射关系
     */
    private SortedMap<Integer, Invoker> virtualNodesMap = new TreeMap<>();

    public ConsistentHashLoadBalance(List<Invoker> invokers) {
        super(invokers);
        putVirtualNodes(invokers);
    }


    /**
     * 添加虚拟节点映射(环)
     * @param invokers
     */
    private void putVirtualNodes(List<Invoker> invokers) {
        for (Invoker invoker : invokers) {
            for (int i = 0; i < VIRTUAL_NODE_NUM; i++) {
                int hash = HashUtils.getHash(invoker.getAddress() + "-" + i);
                virtualNodesMap.put(hash,invoker);
            }
        }
    }

    /**
     * 根据客户端的信息获取 Invoker
     * @param client
     * @return
     */
    public Invoker getInvoker(Object client){
        if (client == null){
            return null;
        }
        //获取大于等于 hash 的第一个 Node
        SortedMap<Integer, Invoker> subMap = virtualNodesMap.tailMap(HashUtils.getHash(client.toString()));
        if (subMap.isEmpty()) {
            // hash值在最尾部，映射到第一个Node上
            return virtualNodesMap.get(virtualNodesMap.firstKey());
        }
        return subMap.get(subMap.firstKey());
    }


    @Override
    public void result(int loop) {
        results.clear();
        if (loop < 1) {
            throw new IllegalArgumentException();
        }
        IntStream.range(0, loop).forEach(i -> results.add(selectHost("test-client-"+i)));
        Set<Multiset.Entry<Invoker>> entrySet = results.entrySet();
        entrySet.stream().sorted(Comparator.comparingInt(Multiset.Entry::getCount)).forEach(System.out::println);
    }

    @Override
    protected boolean addInvoker(Invoker invoker) {
        if (super.addInvoker(invoker)){
            List<Invoker> invokers = getInvokers();
            virtualNodesMap.clear();
            putVirtualNodes(invokers);
            return true;
        }
        return false;
    }

    @Override
    protected boolean removeInvoker(Invoker invoker) {
        if (super.removeInvoker(invoker)){
            List<Invoker> invokers = getInvokers();
            virtualNodesMap.clear();
            putVirtualNodes(invokers);
            return true;
        }
        return false;
    }

    @Override
    protected Invoker doSelect(Object client) {
        return getInvoker(client);
    }
}
