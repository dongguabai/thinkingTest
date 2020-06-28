package dongguabai.demo.roundrobin;

import dongguabai.demo.Invoker;

import java.util.List;

/**
 * @author Dongguabai
 * @Description 平滑加权轮询
 * @Date 创建于 2020-06-27 16:35
 */
public class SmoothWeightRoundRobinLoadBalance extends SimpleRoundRobinLoadBalance {

    private boolean averageWeight = true;

    private int totalWeight;

    private final Object lock = new Object();

    public SmoothWeightRoundRobinLoadBalance(List<Invoker> invokers) {
        super(invokers);
        for (int i = 0; i < invokers.size(); i++) {
            Invoker invoker = invokers.get(i);
            if (averageWeight && i > 0 && invoker.getWeight() != invokers.get(i - 1).getWeight()) {
                averageWeight = false;
            }
            totalWeight += invoker.getWeight();
        }
    }

    @Override
    protected Invoker doSelect() {
        if (averageWeight || totalWeight < 1) {
            return super.doSelect();
        }
        synchronized (lock) {
            Invoker doInvoker = selectInvoker(invokers);
            before(doInvoker);
            return doInvoker;
        }
    }

    private Invoker selectInvoker(List<Invoker> invokers) {
        Invoker maxCurrentInvoker = invokers.get(0);
        for (Invoker invoker : invokers) {
            invoker.setCurrentWeight(invoker.getWeight() + invoker.getCurrentWeight());
            if (maxCurrentInvoker.getCurrentWeight() < invoker.getCurrentWeight()) {
                maxCurrentInvoker = invoker;
            }
        }
        return maxCurrentInvoker;
    }

    private void before(Invoker doInvoker) {
        doInvoker.setCurrentWeight(doInvoker.getCurrentWeight() - totalWeight);
    }
}
