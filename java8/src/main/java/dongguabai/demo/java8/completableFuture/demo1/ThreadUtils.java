package dongguabai.demo.java8.completableFuture.demo1;

import java.util.concurrent.TimeUnit;

/**
 * @author 魏民
 * @Description
 * @Date 创建于 2019-11-01 13:02
 */

public abstract class ThreadUtils {

    public static void sleepAround(int seconds,Runnable before,Runnable after){
        before.run();
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        after.run();
    }

    public static void sleepBefore(int seconds,Runnable before){
        before.run();
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void sleepAfter(int seconds,Runnable after){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        after.run();
    }

    public static void sleep(int seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
