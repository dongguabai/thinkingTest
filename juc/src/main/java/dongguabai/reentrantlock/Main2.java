package dongguabai.reentrantlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2021-01-04 10:40
 */
public class Main2 {

    static Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {


        new Thread(()->{
            lock.lock();
            lock.lock();
            lock.lock();
            System.out.println(Thread.currentThread().getName()+"-------");
            lock.unlock();
            lock.unlock();
        }).start();
        Thread.sleep(10);
        new Thread(()->{
            lock.lock();
            System.out.println(Thread.currentThread().getName()+"1111");
            lock.unlock();
        }).start();
    }
}
