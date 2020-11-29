package dongguabai.demo.testing.jvm;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2020-11-18 17:03
 */
public class JVMTestMain {

    /**
     * 无法被回收的对象
     */
    private static final byte[] BYTE = new byte[1 * 1024 * 1024];

    private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(10);

    private byte[] bytes = new byte[2 * 1024 * 1024 * 10];

    public static void main(String[] args) throws IOException {
        sleep(10);
        System.out.println("start----->"+new Date());
        int i = 1;
        while (true) {
            int j = i;
            //确保不会出现第一个 Minor GC 后 Survivor 放不下，后文会有说明
            EXECUTOR_SERVICE.submit(() -> process(j > 10 && j % 10 < 3 ? 120 : 0));
            sleep(1);
            i++;
        }

      /* AtomicInteger sum = new AtomicInteger();
        while (true) {
            int j = i;
            //确保不会出现第一个 Minor GC 后 Survivor 放不下，后文会有说明
            EXECUTOR_SERVICE.submit(()->{
                final int i1 = process2(j > 10 && j % 10 < 3 ? 120 : 0);
                sum.addAndGet(i1);
            });
            sleep(1);
            i++;
            if ( i == 121){
                break;
            }
        }
        System.out.println("sssssun:"+sum);*/
    }

    private static JVMTestMain process(long timeout) {
        final JVMTestMain jvmTestMain = create();
        sleep(timeout);
        System.out.println(new Date().toLocaleString());
        return jvmTestMain;
    }

    private static int process2(long timeout) {
        sleep(timeout);
        return 20;
    }

    private static void sleep(long timeout) {
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 20M
     */
    private static JVMTestMain create() {
        return new JVMTestMain();
    }

   /* public static void main(String[] args) {
        int i = 1;
        int sum = 0;
        while (true) {
            int j = i;
            //确保不会出现第一个 Minor GC 后 Survivor 放不下，后文会有说明
            EXECUTOR_SERVICE.submit(() -> process(j > 10 && j % 10 < 3 ? 120 : 0));
            sleep(1);
            i++;
        }
    }*/
}
