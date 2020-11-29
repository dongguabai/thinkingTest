package dongguabai.threadpool;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2020-11-29 18:57
 */
public class TestMain6 {

    public static void main(String[] args) {
        //默认10s回收
        MyThreadPool myThreadPool = new MyThreadPool(10, 20);
        myThreadPool.setAllowCoreThreadTimeOut(true);
        process(myThreadPool);
        process(myThreadPool);

    }

    private static void process(MyThreadPool myThreadPool) {
        IntStream.range(0, 40).forEach(i -> {
            myThreadPool.execute(() -> {
                System.out.printf("%s：%s->执行任务[%s]\n", new Date().toLocaleString(), Thread.currentThread().getName(), i);
            });
        });
        sleep(1);
        System.out.printf("%s：线程数量:[%d]\n",new Date().toLocaleString(),myThreadPool.getPoolSize());
        sleep(10);
        System.out.printf("%s：线程数量:[%d]\n",new Date().toLocaleString(),myThreadPool.getPoolSize());
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
}
