package dongguabai.algorithm;

/**
 * @author Dongguabai
 * @Description https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 * @Date 创建于 2020-07-16 13:09
 */
public class 打印从1到最大的n位数 {

    public static int[] printNumbers(int n) {
        int result = (int) Math.pow(10, n);
        int[] arr = new int[result-1];
        for (int i = 0,length = result-1; i < length; i++) {
            arr[i] = i+1;
        }
        return arr;
    }


    public static void main(String[] args) {
        int[] ints = printNumbers(3);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
