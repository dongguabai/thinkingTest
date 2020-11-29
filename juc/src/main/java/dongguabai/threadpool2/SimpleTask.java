package dongguabai.threadpool2;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2020-11-29 12:43
 */
public class SimpleTask {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
        SimpleThreadPool simpleThreadPool = new SimpleThreadPool();

        IntStream.range(0,40).forEach(i->{
            simpleThreadPool.submit(()->{
                System.out.printf("%s：%s->执行任务[%s]\n",new Date().toLocaleString(),Thread.currentThread().getName(),i);
                randomSleep();
            });
            System.out.println("========");
        });

    }

    private static void randomSleep() {
        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
