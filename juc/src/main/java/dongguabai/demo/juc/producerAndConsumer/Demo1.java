package dongguabai.demo.juc.producerAndConsumer;

import java.time.LocalDateTime;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author dongguabai
 * @date 2019-03-22 18:44
 */
public class Demo1 {

    private static LinkedBlockingDeque<String[]> queue = new LinkedBlockingDeque<>();

    static class Producer implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String[] product = new String[1024000];
                queue.push(product);
                System.out.println(LocalDateTime.now()+"已经生产了【【【" + product);
            }
        }
    }


    static class Consumer implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String[] s = null;
                try {
                    s = queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("获取产品" + s);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Producer()).start();
        Thread.sleep(500);
        new Thread(new Consumer()).start();
    }
}
