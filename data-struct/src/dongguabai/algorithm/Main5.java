package dongguabai.algorithm;

import java.util.concurrent.CountDownLatch;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2020-12-29 15:38
 */
public class Main5 {

    private static class T {
        private  long p1, p2, p3, p4, p5, p6, p7;

        private volatile long x = 0L;

        private  long p9, p10, p11, p12, p13, p14, p15;
    }

    private static T[] arr = new T[2];

    private static long count = 1_0000_0000L;

    static {
        arr[0] = new T();
        arr[1] = new T();
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);
        Thread t1 = new Thread(()->{
            for (int i = 0; i < count; i++) {
                arr[0].x = i;
            }
            latch.countDown();
        });

        Thread t2 = new Thread(()->{
            for (int i = 0; i < count; i++) {
                arr[0].x = i;
            }
            latch.countDown();
        });

        final long start = System.nanoTime();
        t1.start();
        t2.start();
        latch.await();
        final long end = System.nanoTime();
        System.out.println((end-start)/1000);

    }
}
