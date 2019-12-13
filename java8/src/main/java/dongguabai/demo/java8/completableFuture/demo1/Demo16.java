package dongguabai.demo.java8.completableFuture.demo1;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author 魏民
 * @Description
 * @Date 创建于 2019-11-01 16:36
 * completeExceptionally  直接放弃future(无论是否完成)   completeValue()
 */
public class Demo16 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("=========");
            ThreadUtils.sleep(3);
            return "hello";
        });
        ThreadUtils.sleep(4);
        future.obtrudeValue("aa");
        System.out.println(future.get());
    }
}
