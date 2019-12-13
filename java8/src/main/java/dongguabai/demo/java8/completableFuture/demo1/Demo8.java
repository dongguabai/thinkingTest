package dongguabai.demo.java8.completableFuture.demo1;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author 魏民
 * @Description
 * @Date 创建于 2019-11-01 13:20
 *
 * acceptEither
 */
public class Demo8 {

    public static void main(String[] args) throws IOException {
        acceptEitherTest();
        System.in.read();
    }

    private static void acceptEitherTest(){
        CompletableFuture.supplyAsync(()->{
            ThreadUtils.sleepAround(3,()-> System.out.println("before1"),()-> System.out.println("end1"));
            return "hello";
        }).acceptEither(CompletableFuture.supplyAsync(()->{
            ThreadUtils.sleepAround(5,()-> System.out.println("before2"),()-> System.out.println("end2"));
            return "world";
        }),(s)-> System.out.println(s+"-"));
    }
}
