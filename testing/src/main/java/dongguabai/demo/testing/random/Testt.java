package dongguabai.demo.testing.random;

import java.util.concurrent.TimeUnit;

/**
 * @author 魏民
 * @Description
 * @Date 创建于 2019-04-28 12:17
 */
public class Testt {

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            System.out.println(ThreadLocalRandomTest.random.toString());
        }).start();

        new Thread(()->{
            System.out.println(ThreadLocalRandomTest.random.toString());
        }).start();

        TimeUnit.SECONDS.sleep(1);
    }
}
