package dongguabai.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author Dongguabai
 * @description
 * @date 2019-01-21 19:33
 */
public final class UnsafeUtils {

    private static final Unsafe UNSAFE;

    static {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            UNSAFE = (Unsafe) theUnsafe.get(null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new Error(e);
        }
    }

    public static Unsafe getUnsafe(){
        return UNSAFE;
    }
}
