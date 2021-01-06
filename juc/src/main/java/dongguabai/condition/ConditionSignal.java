package dongguabai.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2020-12-31 15:36
 */
public class ConditionSignal extends Thread {

    private Lock lock;

    private Condition condition;

    @Override
    public void run() {
        lock.lock();
        System.out.println(Thread.currentThread().getName() + "--->before Signal...");
        condition.signal();
        System.out.println("已经signal了");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
        System.out.println(Thread.currentThread().getName() + "--->after Signal...");
    }

    public ConditionSignal(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }
}
