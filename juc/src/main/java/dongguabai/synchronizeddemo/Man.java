package dongguabai.synchronizeddemo;

import java.util.concurrent.TimeUnit;

/**
 * @author dongguabai
 * @date 2019-03-24 11:47
 */
public class Man {

    public  void do1(){
        System.out.println("-------");
        synchronized(this) {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("do1...");
        }
    }

    public void do2(){
        System.out.println("do2...");
    }


    public static void main(String[] args) throws InterruptedException {

        System.getProperties();
        int i = Runtime.getRuntime().availableProcessors();
        System.out.println(i);
        Man man = new Man();
        new Thread(()->man.do1()).start();

        Thread.sleep(50);
        new Thread(()->man.do2()).start();
    }
}
