package dongguabai.algorithm;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2020-12-29 16:00
 */
public class Main7 {

    public static void main(String[] args) throws InterruptedException, NoSuchFieldException, IllegalAccessException {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);
        final int i1 = unsafe.addressSize();



        System.out.println(i1);
        ReentrantLock lock = new ReentrantLock();

        for (int i = 1; i <= 3; i++) {
            lock.lock();
        }

        for(int i=1;i<=5;i++){
            try {

            } finally {
                lock.unlock();
            }
        }
    }
}
