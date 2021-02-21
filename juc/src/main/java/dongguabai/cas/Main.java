package dongguabai.cas;

/**
 * @author Dongguabai
 * @description
 * @date 2021-02-21 18:56
 */
public class Main {

    public static void main(String[] args) {
        CasLock lock = new CasLock();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"->尝试加锁");
            try {
                lock.lock();
            }finally {
                lock.unLock();
            }
        }).start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"->尝试加锁");
            try {
                lock.lock();
            }finally {
                lock.unLock();
            }
        }).start();
    }
}
