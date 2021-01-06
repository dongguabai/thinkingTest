package dongguabai.park;

import java.util.concurrent.locks.LockSupport;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2021-01-04 12:39
 */
public class ParkDemo {

    public static void main(String[] args) throws InterruptedException {
        final Thread thread = new Thread(() -> {
            System.out.println("before...");
            LockSupport.park();
            System.out.println("aaaa");
        });
        Thread.sleep(1000);
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();

    }
}
