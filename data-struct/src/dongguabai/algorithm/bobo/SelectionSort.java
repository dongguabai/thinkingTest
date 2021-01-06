package dongguabai.algorithm.bobo;

import java.util.stream.Stream;

/**
 * @author Dongguabai
 * @Description 选择排序
 * @Date 创建于 2021-01-06 04:57
 */
public class SelectionSort {

    public static void main(String[] args) {

        Integer[] arr = {2,1,5,3,8,6,4,5,0,9,1};
        selectionSort2(arr);
        Stream.of(arr).forEach(a-> System.out.print(a+" "));
    }

    private static void selectionSort(Integer[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j <arr.length ; j++) {
                if (arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    private static void selectionSort2(Integer[] arr){
        for (int i = arr.length-1; i >= 0; i--) {
            for (int j = i-1; j >=0 ; j--) {
                if (arr[i] < arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
