package dongguabai.demo.random;

import dongguabai.demo.AbstractLoadBalance;
import dongguabai.demo.Invoker;

import java.util.List;
import java.util.Random;

/**
 * @author Dongguabai
 * @Description 随机
 * @Date 创建于 2020-06-23 18:57
 */
public class SimpleRandomLoadBalance extends AbstractLoadBalance {

    public SimpleRandomLoadBalance(List<Invoker> invokers) {
        super(invokers);
    }

    @Override
    protected Invoker doSelect() {
        return getInvokers().get(new Random().nextInt(getInvokers().size()));
    }

    @Override
    public List<Invoker> getInvokers() {
        return invokers;
    }

}
