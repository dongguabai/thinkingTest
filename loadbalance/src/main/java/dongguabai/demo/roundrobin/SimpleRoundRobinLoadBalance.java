package dongguabai.demo.roundrobin;

import dongguabai.demo.AbstractLoadBalance;
import dongguabai.demo.Invoker;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2020-06-25 13:48
 */
public class SimpleRoundRobinLoadBalance extends AbstractLoadBalance {

    protected AtomicInteger offset = new AtomicInteger(-1);

    public SimpleRoundRobinLoadBalance(List<Invoker> invokers) {
        super(invokers);
    }

    @Override
    protected Invoker doSelect() {
        return getInvokers().get(offset.addAndGet(1) % getInvokers().size());
    }

}
