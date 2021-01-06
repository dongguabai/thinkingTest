package dongguabai.algorithm.bobo;

import java.util.stream.Stream;

/**
 * @author Dongguabai
 * @Description 插入排序
 * @Date 创建于 2021-01-06 14:14
 */
public class InsertSort {

    public static void main(String[] args) {
        Integer[] arr = {2, 1, 5, 3, 8, 6, 4, 5, 0, 9, 1};
        insertSort3(arr);
        System.out.println("0 1 1 2 3 4 5 5 6 8 9 ");
        Stream.of(arr).forEach(a -> System.out.print(a + " "));
    }

    /**
     * 我的实现
     *
     * @param arr
     */
    private static void insertSort(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int yidong = i;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[yidong] >= arr[j]) {
                    break;
                }
                int temp = arr[yidong];
                arr[yidong] = arr[j];
                arr[j] = temp;
                //交换要移动的指针
                yidong = j;
            }
        }
    }

    /**
     * 老师的实现
     * 内层循环对当前元素前面有序表进行待插入位置查找，并进行移动
     *
     * @param arr
     */
    private static void insertSort2(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j >= 1; j--) {
                if (arr[j] >= arr[j - 1]) {
                    break;
                }
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }
        }
    }

    /**
     * 对上面方法 for 改一下
     * @param arr
     */
    private static void insertSort3(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j >= 1 && arr[j] < arr[j - 1]; j--) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }
        }
    }
}
