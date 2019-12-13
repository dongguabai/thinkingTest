package dongguabai.demo.java8.completableFuture.demo1;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author 魏民
 * @Description
 * @Date 创建于 2019-11-01 10:14
 *
 * thenApply  thenApply 处理异步任务结果
 */
public class Demo5 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<Integer> integerCompletableFuture = stringCompletableFuture.thenApply(s -> s.length());
        System.out.println(integerCompletableFuture.get());
        Thread.currentThread().join();
    }
}
