package dongguabai.algorithm;

/**
 * @author Dongguabai
 * @Description
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 *
 * 示例 1:
 *
 * 输入: "abab"
 *
 * 输出: True
 *
 * 解释: 可由子字符串 "ab" 重复两次构成。
 * 示例 2:
 *
 * 输入: "aba"
 *
 * 输出: False
 * 示例 3:
 *
 * 输入: "abcabcabcabc"
 *
 * 输出: True
 *
 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/repeated-substring-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 创建于 2020-07-30 19:22
 */
public class 重复的子字符串 {

    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println(repeatedSubstringPattern(s));
    }

    /**
     * 解题思路
     * 假设给定字符串s可由一个子串x重复n次构成，即s=nx。
     * 现构造新字符串t=2s，即两个s相加，由于s=nx，则t=2nx。
     * 去掉t的开头与结尾两位，则这两处的子串被破坏掉，此时t中包含2n-2个子串。
     * 由于t中包含2n-2个子串，s中包含n个子串，若t中包含s，则有2n-2>=n，可得n>=2，由此我们可知字符串s可由一个子串x重复至少2次构成，判定为true；反之，若t中不包含s，则有2n-2<n，可得n<2，n只能为1，由此我们可知字符串s=x，假定的子串就为s本身，判定为false。
     *
     * 作者：wandore
     * 链接：https://leetcode-cn.com/problems/repeated-substring-pattern/solution/guan-yu-gou-zao-ssjin-xing-pan-duan-de-zheng-ming-/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     *
     * // 假设 S 由 s 重复 N (N>1)此组成，则 S+S由s重复2N次组成，
     * // 去掉头和尾相当于破坏了2个s, 此时 S+S[1:-1] 仍包含(2N-2)个s
     * // 若 2N-2 == 0，说明N=1，S由1个s组成，返回false
     * // 若 2N-2>0，说明 N>=2，S由两个以上s组成，返回true
     *
     * 作者：18811569665
     * 链接：https://leetcode-cn.com/problems/repeated-substring-pattern/solution/shuo-shi-hua-hen-duo-jie-shi-fei-jing-shuo-bu-qing/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param s
     * @return
     */
    public static boolean repeatedSubstringPattern(String s) {
        /*String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);*/
        return (s+s).substring(1,2*s.length()-1).contains(s);
    }
}
