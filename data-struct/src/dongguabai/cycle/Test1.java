package dongguabai.cycle;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2021-01-08 11:19
 */
public class Test1 {

    public static void main(String[] args) {
       String s = "2020-11-26";
    }

    //左边OK
    private static void insertSort(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j;
            for ( j = i; j >=1 && temp < arr[j-1] ; j--) {
                arr[j] = arr[j-1];
            }
            arr[j]  = temp;
        }
    }
}
