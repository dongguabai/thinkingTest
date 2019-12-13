package dongguabai.demo.java8.completableFuture.demo1;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.CompletableFuture;

/**
 * @author 魏民
 * @Description
 * @Date 创建于 2019-11-01 13:33
 *
 * runAfterEither
 */
public class Demo10 {

    public static void main(String[] args) throws InterruptedException {
       /* runAfterEitherTest();
        Thread.currentThread().join();*/
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal2.set(cal1.get(Calendar.YEAR), cal1.get(Calendar.MONTH),
                cal1.get(Calendar.DATE), 0, 0, 0);
        Date now = cal2.getTime();
        System.out.println(now.toLocaleString());
    }

    private static void runAfterEitherTest(){
        CompletableFuture.supplyAsync(()->{
            ThreadUtils.sleepAround(3,()-> System.out.println("before1"),()-> System.out.println("end1"));
            return "hello";
        }).runAfterEither(CompletableFuture.supplyAsync(()->{
            ThreadUtils.sleepAround(5,()-> System.out.println("before2"),()-> System.out.println("end2"));
            return "world";
        }),()-> System.out.println(" one done"));
    }
}
