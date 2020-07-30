package dongguabai.algorithm;

import java.util.HashSet;
import java.util.stream.IntStream;

/**
 * @author Dongguabai
 * @Description
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 *
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 创建于 2020-07-30 17:22
 */
public class 存在重复元素 {

    public boolean containsDuplicate1(int[] nums) {
        //todo 判空，元素为1
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int now = nums[i];
            for (int j = i+1; j < length; j++) {
                if (now == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) {

       return IntStream.of(nums).distinct().count() != nums.length;
    }

    public static void main(String[] args) {
        int[] arr = {1,1025};
        //System.out.println(containsDuplicate(arr));
    }

}
