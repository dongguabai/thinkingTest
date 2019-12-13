package dongguabai.demo.java8.completableFuture.demo1;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @author 魏民
 * @Description
 * @Date 创建于 2019-11-01 18:16
 */
public class Demo18 {

    public static void main(String[] args) {

        Map<Integer, String> works = new HashMap<>(6);
        works.put(0, "a");
        works.put(1, "b");
        works.put(2, "c");
        works.put(3, "d");
        works.put(4, "e");
        works.put(5, "f");

        Map<Integer, String> resultMapv = new ConcurrentHashMap<>(6);

        System.out.println("Strat." + new Date().toLocaleString());

        CompletableFuture[] array = works.entrySet().stream().map(integerStringEntry ->
                CompletableFuture
                        .supplyAsync(() -> process(integerStringEntry))
                        .whenComplete((result, e) -> {
                            resultMapv.put(result.getKey(),result.getValue());
                        })
        ).toArray(CompletableFuture[]::new);
        CompletableFuture.allOf(array).join();
        System.out.println("End."+new Date().toLocaleString());
        System.out.println(resultMapv);
    }

    private static Map.Entry<Integer, String> process(Map.Entry<Integer, String> entry) {
        int workingTime = ThreadLocalRandom.current().nextInt(1, 10);
        try {
            TimeUnit.SECONDS.sleep(workingTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "完成工作，用时：" + workingTime);
        entry.setValue(entry.getValue() + "_finished");
        return entry;
    }

}
