package dongguabai.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Dongguabai
 * @description
 * @date 2021-02-21 16:35
 */
public class AtomicIntegerDemo {

    static int i ;

    static AtomicInteger j = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {

        System.out.println("i++：");
        for (int k = 0; k < 10; k++) {
            new Thread(()-> System.out.println(++i)).start();
        }
        Thread.sleep(1000);
        System.out.println("\nAtomicInteger：");
        for (int k = 0; k < 10; k++) {
            new Thread(()-> System.out.println(j.incrementAndGet())).start();
        }
        Thread.sleep(1000);
        System.out.println("\nAtomicInteger：");
        MyAtomicInteger myAtomicInteger = new MyAtomicInteger();
        for (int k = 0; k < 10; k++) {
            new Thread(()-> System.out.println(myAtomicInteger.incrementAndGet())).start();
        }

        Thread.sleep(1000);
        System.out.println("\nAtomicInteger2：");
        MyAtomicInteger myAtomicInteger2 = new MyAtomicInteger();
        for (int k = 0; k < 10; k++) {
            new Thread(()-> System.out.println(myAtomicInteger2.incrementAndGet2())).start();
        }
    }
}
