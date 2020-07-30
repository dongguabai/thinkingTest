package dongguabai.training;

import javax.activation.MailcapCommandMap;
import java.util.stream.IntStream;

/**
 * @author Dongguabai
 * @Description 打印从1到最大的n位数
 * @Date 创建于 2020-07-30 10:08
 */
public class C1 {

    public static int[] printNumbers(int n) {
        int pow = (int) Math.pow(10, n);
        int[] arr = new int[pow-1];
        for (int i = 0; i < pow-1; i++) {
            arr[i] = (i+1);
        }
        return arr;
    }

    public static void main(String[] args) {
        IntStream.of(printNumbers(3)).forEach(System.out::println);
    }

}
