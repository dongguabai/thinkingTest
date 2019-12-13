package dongguabai.demo.java8.completableFuture.demo1;

import org.checkerframework.checker.units.qual.C;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author 魏民
 * @Description
 * @Date 创建于 2019-11-01
 *
 * 异步回调
 */
public class Demo2 {

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture.runAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).whenComplete((v,e)-> System.out.println("complete!"));
        System.out.println("-------------");

        Thread.currentThread().join();
    }
}
