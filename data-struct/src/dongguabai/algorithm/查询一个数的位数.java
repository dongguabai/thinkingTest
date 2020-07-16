package dongguabai.algorithm;

/**
 * @author Dongguabai
 * @Description O(log10(n))
 * @Date 创建于 2020-07-16 12:54
 */
public class 查询一个数的位数 {

    private static int getLength(int num) {
        num = Math.abs(num);
        int i = 1;
        while (num >= 10) {
            i++;
            num = num/10;
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(getLength(1));
        System.out.println(getLength(10));
        System.out.println(getLength(100));
        System.out.println(getLength(1000));
        System.out.println(getLength(10000));
        System.out.println(getLength(9));
        System.out.println(getLength(99));
        System.out.println(getLength(999));
    }

}
