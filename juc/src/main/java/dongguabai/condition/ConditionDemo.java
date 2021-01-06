package dongguabai.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2020-12-31 15:22
 */
public class ConditionDemo {


    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        final Condition condition = lock.newCondition();
        new ConditionWait(lock,condition).start();
        Thread.sleep(1000);
        ConditionSignal conditionSignal = new ConditionSignal(lock,condition);
        conditionSignal.start();
    }
}
