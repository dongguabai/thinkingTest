package dongguabai.demo.random;

import dongguabai.demo.Invoker;

import java.util.List;
import java.util.Random;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2020-06-24 17:10
 */
public class SectionWeightRandomLoadBalance extends SimpleRandomLoadBalance {

    private boolean averageWeight = true;

    private int totalWeight;

    public SectionWeightRandomLoadBalance(List<Invoker> invokers) {
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
        int index = new Random().nextInt(totalWeight);
        for (Invoker invoker : invokers) {
            if (index < invoker.getWeight()) {
                return invoker;
            }
            index -= invoker.getWeight();
        }
        return super.doSelect();
    }
}
