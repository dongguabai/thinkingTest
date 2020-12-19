package dongguabai.interrupt;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2020-12-17 14:18
 */
public class Demo {
    public static void main(String[] args) throws InterruptedException {
        final Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().isInterrupted());
            Thread.currentThread().interrupt();
            System.out.println(Thread.currentThread().isInterrupted());
        });
        thread.start();

        Thread.currentThread().join();
       /* System.out.println(thread.isInterrupted()); // false
        thread.interrupt();
        System.out.println(thread.isInterrupted()); // true*/

       /* System.out.println(thread.isInterrupted()); // false

        System.out.println(thread.isInterrupted());*/
    }
}
