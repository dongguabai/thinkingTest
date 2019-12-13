package dongguabai.demo.java8.completableFuture.demo1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author 魏民
 * @Description
 * @Date 创建于 2019-10-31 23:43
 *
 * Future的缺点
 */
public class Demo1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*ExecutorService executorService = Executors.newCachedThreadPool();
        Future<?> future = executorService.submit(() -> {
            TimeUnit.SECONDS.sleep(2);
            System.out.println("------------");
            return 2;
        });
        Object o = future.get();
        System.out.println("======================");
        System.out.println(o);*/
        System.out.println(Runtime.getRuntime().availableProcessors() - 1);

    }
}
