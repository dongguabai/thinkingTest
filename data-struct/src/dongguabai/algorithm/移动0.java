package dongguabai.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Dongguabai
 * @Description https://leetcode-cn.com/problems/move-zeroes/
 * <p>
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 创建于 2020-07-28 23:35
 */
public class 移动0 {

    public static void main(String[] args) {

        int[] arr = {-1,0, 0, 1, 0, 3, 12, 0, 0, 1, 0, 9, 9, 9, 9, 9};

        moveZeroes4(arr);
        IntStream.of(arr).forEach(System.out::println);

    }

    /**
     * 指针法，2次循环,每个非0的都移动到前面，剩下的全部置为0即可，因为0都是0没区别
     *
     * @param nums
     */
    public static void moveZeroes1(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int j = 0;
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        if (j == 0) {
            return;
        }
        for (; j < size; j++) {
            nums[j] = 0;
        }

        /**
         * while(j < numsSize)
         *     {
         *         nums[j++] = 0;
         *     }
         */

    }


    /**
     * 一次遍历
     * @param nums
     */
    public static void moveZeroes2(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        //快速排序的思想，所有非0的就都放在左边
        int j = 0;
        for (int i = 0, size = nums.length; i < size; i++) {
            if (nums[i] != 0){
                //找到一个非0的数，与j交换，j++，相当于放在j的左边
                int num = nums[j];
                nums[j] = nums[i];
                nums[i] = num;
                j++;
            }
        }
    }


    /**
     * 注意：错误方式
     *         int[] arr = {-1,0, 0, 1, 0, 3, 12, 0, 0, 1, 0, 9, 9, 9, 9, 9};
     *         忽略了第一个数是非0的情况，所以使用 moveZeroes4() 方法
     * @param nums
     */
    public static void moveZeroes3(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        //快速排序的思想，所有非0的就都放在左边
        int j = 0;
        for (int i = 0, size = nums.length; i < size; i++) {
            if (nums[i] != 0){
                //找到一个非0的数，与j交换，j++，相当于放在j的左边
                nums[j] = nums[i];
                nums[i] = 0;
                j++;
            }
        }
    }

    /**
     * 优化上面
     * @param nums
     */
    public static void moveZeroes4(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        //当i > j 时，只需要把 i 的值赋值给j 并把原位置的值置0。
        // 同时这里也把交换操作换成了赋值操作，减少了一条操作语句，理论上能更节省时间。
        int j = 0;
        for (int i = 0, size = nums.length; i < size; i++) {
            if (nums[i] != 0){
                nums[j] = nums[i];
                if (i > j){ //同 i!=j
                    nums[i] = 0;
                }
                j++;

            }
        }
    }
}
