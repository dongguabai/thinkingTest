package dongguabai.algorithm;

/**
 * @author Dongguabai
 * @Description https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 *
 * 找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 示例 1：
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *  
 *
 * 限制：
 *
 * 2 <= n <= 100000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Date 创建于 2020-07-30 16:16
 */
public class 数组中重复的数字 {



    //2 <= n <= 100000
    public  static  int findRepeatNumber1(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int now = nums[i];
            for (int j = i+1; j < length; j++) {
                if (now == nums[j]){
                    return now;
                }
            }
        }
        return -1;
    }

    public static int findRepeatNumber2(int[] nums) {
        for (int i = 0, length = nums.length ; i < length; i++) {
            while (i != nums[i]){ //如果当前这个 i 所在的元素不等于 num[i]，那么就将索引为 num[i] 的设置为 num[i]（交换）
                int temp = nums[nums[i]];
                if (nums[i] == temp){
                    return nums[i];
                }
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
        }
        return -1;
    }

    //在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内,也就是说正常来说 i 应该在 index 为 i 的位置
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 3};
        System.out.println(findRepeatNumber2(arr));
    }

}
