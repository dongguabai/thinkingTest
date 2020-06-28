package dongguabai.demo.random;

import dongguabai.demo.Invoker;
import dongguabai.demo.random.SimpleRandomLoadBalance;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author Dongguabai
 * @Description 加权随机（复制）
 * @Date 创建于 2020-06-24 10:30
 */
public class CopyWeightRandomLoadBalance extends SimpleRandomLoadBalance {


    private List<Invoker> weightInvokers = new ArrayList<>();


    public CopyWeightRandomLoadBalance(List<Invoker> invokers) {
        super(invokers);
        if (!CollectionUtils.isEmpty(invokers)){
            invokers.forEach(invoker -> {
                if (invoker.getWeight() < 2) {
                    weightInvokers.add(invoker);
                    return;
                }
                IntStream.range(0,invoker.getWeight()).forEach(i->weightInvokers.add(invoker));
            });
        }
    }

    @Override
    public final List<Invoker> getInvokers() {
        return weightInvokers;
    }
}
