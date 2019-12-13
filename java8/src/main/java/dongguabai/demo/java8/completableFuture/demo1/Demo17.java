package dongguabai.demo.java8.completableFuture.demo1;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author 魏民
 * @Description
 * @Date 创建于 2019-11-01 16:39
 * <p>
 * 综合
 */
public class Demo17 {

    public static void main(String[] args) throws InterruptedException, ExecutionException, IOException {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> Demo17.doTask(1));
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> Demo17.doTask(2));
        CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> Demo17.doTask(3));
        CompletableFuture<Object> objectCompletableFuture = CompletableFuture.anyOf(future3, future1, future2);
        Object o = objectCompletableFuture.get();
        Object o2 = objectCompletableFuture.get();
        Object o3 = objectCompletableFuture.get();
        System.out.println(o);
        System.out.println(o2);
        System.out.println(o3);
        System.in.read();

    }

    private static Integer doTask(int seconds){
        ThreadUtils.sleep(seconds);
        System.out.println(Thread.currentThread().getName());
        return seconds;
    }
}
