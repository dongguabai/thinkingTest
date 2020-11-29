package dongguabai.threadpool;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2020-11-29 17:04
 */
public class TestMain3 {

    public static void main(String[] args) {
        MyThreadPool myThreadPool = new MyThreadPool(10, 20);
        IntStream.range(0, 40).forEach(i -> {
            myThreadPool.execute(() -> {
                workTime(1000+new Random().nextInt(5000));
                System.out.printf("%s：%s->执行任务[%s]\n", new Date().toLocaleString(), Thread.currentThread().getName(), i);
            });
        });
        sleep(1);
        myThreadPool.shutDown();
        myThreadPool.execute(System.out::println);
    }


    private static void workTime(long ms) {
        final long l = System.currentTimeMillis();
        while (System.currentTimeMillis() <= l + ms) {
        }
    }

    private static void sleep(long timeout) {
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static void randomSleep() {
        sleep(new Random().nextInt(10));
    }
}
