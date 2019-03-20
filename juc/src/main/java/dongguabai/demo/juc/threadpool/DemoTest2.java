package dongguabai.demo.juc.threadpool;

import java.util.concurrent.*;

/**
 * @author dongguabai
 * @date 2019-03-20 16:16
 *
 * 查看线程池的执行流程
 */
public class DemoTest2 {

    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor
                (10, 20, 1000, TimeUnit.SECONDS
                        , new LinkedBlockingDeque<>(10), (ThreadFactory) target -> {
                    Thread thread = new Thread(target);
                    thread.setDaemon(true);
                    return thread;
                });

        new Thread(() -> {
            while (true) {
                System.out.println("队列元素数量：" + ((ThreadPoolExecutor) executorService).getQueue().size());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        for (int i = 0; i < 11; i++) {
            executorService.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "   开始执行");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "   执行结束");
            });
        }
    }
}
