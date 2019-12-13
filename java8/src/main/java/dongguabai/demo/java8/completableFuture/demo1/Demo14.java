package dongguabai.demo.java8.completableFuture.demo1;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author 魏民
 * @Description
 * @Date 创建于 2019-11-01 16:23
 *
 * complete 强制停止返回数据
 */
public class Demo14 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            ThreadUtils.sleep(3);
            System.out.println("=========");
            return "hello";
        });
        ThreadUtils.sleep(4);
        boolean finished = future.complete("haha");
        System.out.println(finished);
        System.out.println(future.get());

    }
}
