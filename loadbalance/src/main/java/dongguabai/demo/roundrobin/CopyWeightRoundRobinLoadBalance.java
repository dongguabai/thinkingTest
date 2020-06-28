package dongguabai.demo.roundrobin;

import dongguabai.demo.Invoker;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2020-06-25 17:33
 */
public class CopyWeightRoundRobinLoadBalance extends SimpleRoundRobinLoadBalance{

    private List<Invoker> weightInvokers = new ArrayList<>();

    public CopyWeightRoundRobinLoadBalance(List<Invoker> invokers) {
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
