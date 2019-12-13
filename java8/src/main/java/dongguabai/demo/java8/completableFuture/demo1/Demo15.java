package dongguabai.demo.java8.completableFuture.demo1;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author 魏民
 * @Description
 * @Date 创建于 2019-11-01 16:29
 *
 * join  unchecked Exception  get()
 */
public class Demo15 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            ThreadUtils.sleep(3);
            System.out.println("=========");
            return "hello";
        });
        String result = future.join();
        String s = future.get();
        System.out.println(result);
    }
}
