package dongguabai.wait_notify;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2020-12-31 15:47
 */
public class Demo {

    static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            synchronized (lock){
                System.out.println("before---wait");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("after---wait");
            }
        }).start();

        Thread.sleep(100);

        new Thread(()->{
            synchronized (lock){
                System.out.println("before---notify");
                lock.notify();
                System.out.println("notify了");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("after---notify");
            }
        }).start();
    }
}
