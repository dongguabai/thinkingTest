package dongguabai.demo.juc.threadpool;

import java.util.concurrent.*;

/**
 * @author dongguabai
 * @date 2019-03-19 23:24
 *
 * 线程池无法关闭例子
 */
public class Demo2 {


    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = new ThreadPoolExecutor
                (10, 20, 1000, TimeUnit.SECONDS
                        , new LinkedBlockingDeque<>(1), (ThreadFactory) target -> {
                    Thread thread = new Thread(target);
                    thread.setDaemon(true);
                    return thread;
                });

        for (int i = 0; i < 2; i++) {
            executorService.submit(() -> {
               // try {
                while (true) {
                  //  System.out.println(Thread.currentThread().getName() + "  执行任务完毕");
                }
            });
        }

       executorService.shutdown();
       //executorService.awaitTermination(1000000,TimeUnit.SECONDS);
       System.out.println("00000000");
    }
}
