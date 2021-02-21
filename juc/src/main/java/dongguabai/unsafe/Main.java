package dongguabai.unsafe;

import sun.misc.Unsafe;

/**
 * @author Dongguabai
 * @description
 * @date 2021-02-21 19:38
 */
public class Main {

    public static void main(String[] args) {
        Unsafe unsafe = UnsafeUtils.getUnsafe();
        int andSetInt = unsafe.getAndSetInt(null, 1L, 1);
        System.out.println(andSetInt);
    }
}
