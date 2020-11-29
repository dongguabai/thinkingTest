package dongguabai.training;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.stream.IntStream;

/**
 * @author Dongguabai
 * @Description
 *
 *
 * 给定一个整数数组，判断是否存在重复元素。
 *  *
 *  * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 *  *
 *  *  
 *  *
 *  * 示例 1:
 *  *
 *  * 输入: [1,2,3,1]
 *  * 输出: true
 *  * 示例 2:
 *  *
 *  * 输入: [1,2,3,4]
 *  * 输出: false
 *  * 示例 3:
 *  *
 *  * 输入: [1,1,1,3,3,4,3,2,4,2]
 *  * 输出: true
 *  *
 *  * 来源：力扣（LeetCode）
 *  * 链接：https://leetcode-cn.com/problems/contains-duplicate
 *
 *
 * @Date 创建于 2020-08-04 09:05
 */
public class C1 {
    public static boolean containsDuplicate(int[] nums) {
        for (int num : nums) {
            System.out.println(num);
        }
        //todo 判空
        System.out.println(IntStream.of(nums).distinct().count() != nums.length);

        for (int num : nums) {
            System.out.println(num);
        }
        return false;
    }



    private static Unsafe getUnsafe() throws Throwable {

        Class<?> unsafeClass = Unsafe.class;

        for (Field f : unsafeClass.getDeclaredFields()) {

            if ("theUnsafe".equals(f.getName())) {

                f.setAccessible(true);

                return (Unsafe) f.get(null);

            }

        }

        throw new IllegalAccessException("no declared field: theUnsafe");

    }

    public static void main(String[] args) throws Throwable {
        Integer[] arr = {1,2,3,4};
        for (Integer integer : arr) {
            System.out.println(Long.toHexString(location(integer)));
        }
    }

    public static long location(Object object) throws Throwable {

        Unsafe unsafe = getUnsafe();



        Object[] array = new Object[] {object};



        long baseOffset = unsafe.arrayBaseOffset(Object[].class);

        int addressSize = unsafe.addressSize();

        long location;

        switch (addressSize) {

            case 4:

                location = unsafe.getInt(array, baseOffset);

                break;

            case 8:

                location = unsafe.getLong(array, baseOffset);

                break;

            default:

                throw new Error("unsupported address size: " + addressSize);

        }

        return (location);

    }
}
