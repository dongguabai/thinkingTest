package dongguabai.demo.java8.completableFuture.demo1;

import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author 魏民
 * @Description
 * @Date 创建于 2019-11-01 13:36
 *
 * thenCombine 获取多个异步结果
 */
public class Demo11 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(thenCombineTest());
    }

    private static Object thenCombineTest() throws ExecutionException, InterruptedException {
       return CompletableFuture.supplyAsync(() -> {
            ThreadUtils.sleepAround(3, () -> System.out.println("before1"), () -> System.out.println("end1"));
            return "hello";
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            ThreadUtils.sleepAround(5, () -> System.out.println("before2"), () -> System.out.println("end2"));
            return 2;
        }), (s, i) -> {
            System.out.println(" all done");
            ArrayList<? extends Serializable> result = Lists.newArrayList(s, i);
            return result;
        }).get();
    }
}
