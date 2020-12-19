package dongguabai.synchronizeddemo;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author Dongguabai
 * @Description 偏向锁
 * @Date 创建于 2020-12-18 09:59
 */
public class Main3 {

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(5000);
        Main3 main3 = new Main3();
        synchronized (main3){
            System.out.println(ClassLayout.parseInstance(main3).toPrintable());
        }
    }

    private static void printClassLayout(Object obj) {
        System.out.printf("[%s]===========\n", Thread.currentThread().getName());
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
        System.out.println("===========");

    }
}
