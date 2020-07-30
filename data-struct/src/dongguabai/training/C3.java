package dongguabai.training;

/**
 * @author Dongguabai
 * @Description
 *
 *  * @Description https://leetcode-cn.com/problems/move-zeroes/
 *  * <p>
 *  * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *  * <p>
 *  * 示例:
 *  * <p>
 *  * 输入: [0,1,0,3,12]
 *  * 输出: [1,3,12,0,0]
 *  * 说明:
 *  * <p>
 *  * 必须在原数组上操作，不能拷贝额外的数组。
 *  * 尽量减少操作次数。
 *  * <p>
 *  * 来源：力扣（LeetCode）
 *  * 链接：https://leetcode-cn.com/problems/move-zeroes
 *  * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *  * @Date 创建于 2020-07-28 23:35
 * @Date 创建于 2020-07-30 10:23
 */
public class C3 {

    public static void moveZeroes1(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int mid = 0;
        for (int i = 0,size = nums.length; i < size; i++) {
            if(nums[i] != 0){
                //交换
                nums[mid] = nums[i];
                if (i>mid){
                    nums[i] = 0;
                }
                mid++;
            }
        }
    }
}
