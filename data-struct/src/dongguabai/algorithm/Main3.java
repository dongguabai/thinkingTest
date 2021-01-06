package dongguabai.algorithm;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2020-12-28 16:20
 */
public class Main3 {
    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->process(),"thread1").start();
        new Thread(()->process(),"thread2").start();

        Thread.currentThread().join();
    }

    private static void process(){
        System.out.println(Thread.currentThread().getName()+"->进入....");
        lock.lock();
        while (true){
            System.out.println(Thread.currentThread().getName()+"->执行======");
        }
    }


}
