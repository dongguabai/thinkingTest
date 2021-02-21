package dongguabai.atomic;

import org.springframework.objenesis.instantiator.util.UnsafeUtils;
import sun.misc.Unsafe;

/**
 * @author Dongguabai
 * @description
 * @date 2021-02-21 19:53
 */
public class MyAtomicInteger {

    private volatile int value;

    private static final long valueOffset;

    private static final Unsafe UNSAFE = UnsafeUtils.getUnsafe();

    static {
        try {
            valueOffset = UNSAFE.objectFieldOffset(MyAtomicInteger.class.getDeclaredField("value"));
        } catch (NoSuchFieldException e) {
           throw new RuntimeException(e);
        }
    }

    public final int incrementAndGet() {
        return UNSAFE.getAndAddInt(this, valueOffset, 1) + 1;
    }

    public final int incrementAndGet2() {
        int i;
        while (true){
            i = value+1;
            if (UNSAFE.compareAndSwapInt(this,valueOffset,value,i)){
                return i;
            }
        }
    }
}
