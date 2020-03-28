package dongguabai.demo.java8.completableFuture.demo1;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author 魏民
 * @Description
 * @Date 创建于 2019-11-01 10:00
 * <p>
 * whenComplete/	whenCompleteAsync（这个方法是同步还是异步的） 异步任务执行完成操作
 */
public class Demo4 {

    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> "Hello").whenComplete((v, t) -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("完成");
        });

        System.out.println("-------");
        System.in.read();

        CompletableFuture.supplyAsync(()->"a").thenApplyAsync(a->a+1).thenApplyAsync(a->a+1);
    }


   /* public static void main(String[] args) throws Exception{
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> "Hello");
        //async
        cf.whenCompleteAsync((v, t) -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("完成");
        });
        String result = cf.get();
        System.out.println(result);
        System.in.read();
    }*/

    /*public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> "Hello").whenCompleteAsync((v, t) -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("完成");
        });
        String result = cf.get();
        System.out.println(result);
        System.in.read();
    }*/


}
