package dongguabai.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2020-12-31 15:24
 */
public class ConditionWait extends Thread{

    private Lock lock;

    private Condition condition;

    @Override
    public void run() {
        lock.lock();
        System.out.println(Thread.currentThread().getName()+"--->before wait...");
        try {
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"--->after wait...");
        lock.unlock();
    }

    public ConditionWait(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }
}
