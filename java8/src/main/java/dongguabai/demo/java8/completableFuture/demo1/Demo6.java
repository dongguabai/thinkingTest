package dongguabai.demo.java8.completableFuture.demo1;

import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;

/**
 * @author 魏民
 * @Description
 * @Date 创建于 2019-11-01 10:19
 *
 * handleAsync   handle  thenApply
 */
public class Demo6 {


   public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            int i = 1/0;
           return  "Hello";
        }).handle((r, e) -> {
            Optional.of(e).ifPresent(throwable ->{
                System.out.println("出现异常");
            });
            return r;
        }).thenApply(r->r+"111");
        System.out.println(future.get());
    }

    /*public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello").handle((r, e) -> r.length()).thenApply(r->r+"111");
        System.out.println(future.get());
    }*/
}
