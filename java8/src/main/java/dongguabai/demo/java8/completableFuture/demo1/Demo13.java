package dongguabai.demo.java8.completableFuture.demo1;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author 魏民
 * @Description
 * @Date 创建于 2019-11-01 16:18
 *
 * getNow
 */
public class Demo13 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            ThreadUtils.sleep(3);
            return "hello";
        });
        String getNow = future.getNow("haha");
        System.out.println(getNow);
        System.out.println(future.get());
    }
}
