package dongguabai.demo.java8.completableFuture.demo1;

import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author 魏民
 * @Description
 * @Date 创建于 2019-11-01 13:52
 *
 * thenCompose 依赖于上一个结果
 */
public class Demo12 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        composeTest();
        Thread.currentThread().join();
    }

    private static void composeTest() throws ExecutionException, InterruptedException {
        CompletableFuture.supplyAsync(() -> {
            ThreadUtils.sleepAround(3, () -> System.out.println("before1"), () -> System.out.println("end1"));
            return "hello";
        }).thenCompose(s->CompletableFuture.supplyAsync(() -> {
            ThreadUtils.sleepAround(3, () -> System.out.println("before2"), () -> System.out.println("end2"));
            return s+" world";
        })).thenAccept(System.out::println);
    }
}
