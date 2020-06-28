package dongguabai.demo;

        import com.google.common.collect.HashMultiset;
        import com.google.common.collect.Multiset;
        import org.springframework.util.CollectionUtils;

        import java.util.Comparator;
        import java.util.List;
        import java.util.Set;
        import java.util.stream.IntStream;

/**
 * @author Dongguabai
 * @Description 抽象类
 * @Date 创建于 2020-06-23 13:41
 */
public abstract class AbstractLoadBalance {

    protected List<Invoker> invokers;

    public AbstractLoadBalance(List<Invoker> invokers) {
        this.invokers = invokers;
    }

    protected final Multiset<Invoker> results = HashMultiset.create();

    public Invoker selectHost(){
        List<Invoker> list = getInvokers();
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        if (list.size() == 1) {
            return list.get(0);
        }
        return doSelect();
    }

    public Invoker selectHost(Object client){
        List<Invoker> list = getInvokers();
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        if (list.size() == 1) {
            return list.get(0);
        }
        return doSelect(client);
    }

    protected Invoker doSelect(){
        return null;
    }

    protected Invoker doSelect(Object client){
        return null;
    }

    //todo 优化refesh
    protected boolean addInvoker(Invoker invoker){
        if (getInvokers() != null){
            return invokers.add(invoker);
        }
        return false;
    }

    //todo 优化refesh
    protected boolean removeInvoker(Invoker invoker){
        if (getInvokers() != null){
            return invokers.remove(invoker);
        }
        return false;
    }

    //todo 不要返回集合
    protected List<Invoker> getInvokers(){
        return invokers;
    }

    public void result(int loop) {
        results.clear();
        if (loop < 1) {
            throw new IllegalArgumentException();
        }
        IntStream.range(0, loop).forEach(i -> results.add(selectHost()));
        Set<Multiset.Entry<Invoker>> entrySet = results.entrySet();
        entrySet.stream().sorted(Comparator.comparingInt(Multiset.Entry::getCount)).forEach(System.out::println);
    }

}
