package dongguabai.demo.roundrobin;

import dongguabai.demo.Invoker;

import java.util.List;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2020-06-27 14:22
 */
public class SectionWeightRoundRobinLoadBalance extends SimpleRoundRobinLoadBalance {

    private boolean averageWeight = true;

    private int totalWeight;

    public SectionWeightRoundRobinLoadBalance(List<Invoker> invokers) {
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
        int index = offset.addAndGet(1) % totalWeight;
        for (Invoker invoker : invokers) {
            if (index < invoker.getWeight()) {
                return invoker;
            }
            index -= invoker.getWeight();
        }
        return super.doSelect();
    }
}
