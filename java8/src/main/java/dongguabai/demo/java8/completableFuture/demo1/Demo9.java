package dongguabai.demo.java8.completableFuture.demo1;

import java.util.concurrent.CompletableFuture;

/**
 * @author 魏民
 * @Description
 * @Date 创建于 2019-11-01 13:28
 *
 * runAfterBoth
 */
public class Demo9 {

    public static void main(String[] args) throws InterruptedException {
        runAfterBothTest();
        Thread.currentThread().join();
    }

    private static void runAfterBothTest(){
        CompletableFuture.supplyAsync(()->{
            ThreadUtils.sleepAround(3,()-> System.out.println("before1"),()-> System.out.println("end1"));
            return "hello";
        }).runAfterBoth(CompletableFuture.supplyAsync(()->{
            ThreadUtils.sleepAround(5,()-> System.out.println("before2"),()-> System.out.println("end2"));
            return "world";
        }),()-> System.out.println(" all done"));
    }
}
