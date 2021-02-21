package dongguabai.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Dongguabai
 * @description
 * @date 2021-02-21 18:53
 */
public class CasLock {

    /**
     * 0 表示未加锁，1表示已锁
     */
    private AtomicInteger state = new AtomicInteger(0);

    public void lock(){
        while (true){
            if (state.compareAndSet(0,1)){
                System.out.println(Thread.currentThread().getName()+"->加锁成功");
                break;
            }
        }
    }

    public void unLock(){
        System.out.println(Thread.currentThread().getName()+"->解锁");
        state.set(0);
    }
}
