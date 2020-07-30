package dongguabai.training;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2020-07-30 10:18
 */
public class C2 {

    private static int getLength(int num) {
        int abs = Math.abs(num);
        int wei = 1;
        while ((abs = abs / 10) >= 1) {
            wei++;
        }
        return wei;
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
