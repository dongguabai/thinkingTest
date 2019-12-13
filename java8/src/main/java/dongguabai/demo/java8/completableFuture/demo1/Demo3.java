package dongguabai.demo.java8.completableFuture.demo1;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @author 魏民
 * @Description
 * @Date 创建于 2019-11-01
 *
 * 处理异步任务结果
 */
public class Demo3 {
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 3; i++) {
            CompletableFuture.supplyAsync(Demo3::code).thenAccept(Demo3::test);
        }
        System.out.println("11111111");
        System.in.read();
    }

    private static Integer code(){
        int workingTime = ThreadLocalRandom.current().nextInt(3, 10);
        try {
            TimeUnit.SECONDS.sleep(workingTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"完成工作，用时："+workingTime);
        return workingTime;
    }

    private static void test(Integer result){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" -测试 【"+result+"】完成，用时："+1);
    }


}
