package dongguabai.threadpool;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2020-11-29 10:11
 */
public class TestMain {

    public static void main(String[] args) {
        MyThreadPool myThreadPool = new MyThreadPool(10,15);
        IntStream.range(0,40).forEach(i->{
            myThreadPool.execute(()->{
                sleep(2);
                System.out.printf("%s：%s->执行任务[%s]\n",new Date().toLocaleString(),Thread.currentThread().getName(),i);
            });
            System.out.println(i+"========");
        });
    }

    private static void sleep(long timeout){
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
