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


    /**
     * 直觉
     *
     * 如果存在重复元素，排序后它们应该相邻。
     *
     * 算法
     *
     * 本方法使用排序算法。由于比较排序算法，如堆排序，可以在最坏情况下具有 O(n \log n)O(nlogn) 的时间复杂度。因此，排序经常是很好的预处理方法。排序之后，我们可以扫描已排序的数组,以查找是否有任何连续的重复元素。
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/contains-duplicate/solution/cun-zai-zhong-fu-yuan-su-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     *
     * 复杂度分析
     *
     * 时间复杂度 : O(n \log n)O(nlogn)。
     * 排序的复杂度是 O(n \log n)O(nlogn)，扫描的复杂度是 O(n)O(n)。整个算法主要由排序过程决定，因此是 O(n \log n)O(nlogn)。
     *
     * 空间复杂度 : O(1)O(1)。
     * 这取决于具体的排序算法实现，通常而言，使用 堆排序 的话，是 O(1)O(1)。
     *
     * 注意
     *
     * 【要注意是否修改了原数组】
     * 此处的算法实现对原始数组进行排序，修改了原始数组。通常，除非调用方清楚输入数据将被修改，否则不应该随意修改输入数据。可以先复制 nums，然后对副本进行操作。
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/contains-duplicate/solution/cun-zai-zhong-fu-yuan-su-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public static boolean containsDuplicate3(int[] nums) {

       return false;
    }


    public static void main(String[] args) {

    }

}
