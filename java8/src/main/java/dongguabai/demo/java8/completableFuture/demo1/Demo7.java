package dongguabai.demo.java8.completableFuture.demo1;

import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

/**
 * @author 魏民
 * @Description
 * @Date 创建于 2019-11-01 12:57
 *
 * 组合 thenAcceptBoth
 */
public class Demo7 {

    public static void main(String[] args) throws IOException {
        thenAcceptBothTest();
        System.in.read();
    }


    //并行执行
    private static void thenAcceptBothTest(){
        CompletableFuture.supplyAsync(()->{
            ThreadUtils.sleepAround(3,()-> System.out.println("before1"),()-> System.out.println("end1"));
            //int i = 1/0;
            return "hello";
        }).thenAcceptBoth(CompletableFuture.supplyAsync(()->{
            ThreadUtils.sleepAround(5,()-> System.out.println("before2"),()-> System.out.println("end2"));
            return "world";
        }),(s,v)-> System.out.println(s+"-"+v));
    }
}
