package dongguabai.demo.testing;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author dongguabai
 * @date 2019-03-20 23:39
 */
public class Test1 {

    public static void main(String[] args) throws InterruptedException {
        int[] arr = {6,3,1,2,4,5};
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i]<arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        for (int i : arr) {
            System.out.println(i);
        }

    }
}
