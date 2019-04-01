package dongguabai.code.interview.single;

/**
 * @author dongguabai
 * @date 2019-03-19 13:28
 * <p>
 * link：https://www.cnblogs.com/morethink/p/8419151.html
 */
public class Sort {

    public static void main(String[] args) {
        System.out.println("aaa".hashCode());
    }

    /**
     * 冒泡排序
     */
    public static void maopao() {
        int[] arr = {1, 3, 2, 5, 4, 7, 6};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("------排序完成------");
        for (int i : arr) {
            System.out.println(i);
        }
    }


    /**
     * 快速排序方法
     *
     * @param array
     * @param start
     * @param end
     * @return
     */
    public static int[] QuickSort(int[] array, int start, int end) {
        if (array.length < 1 || start < 0 || end >= array.length || start > end) {
            return null;
        }
        int smallIndex = partition(array, start, end);
        if (smallIndex > start) {
            QuickSort(array, start, smallIndex - 1);
        }
        if (smallIndex < end) {
            QuickSort(array, smallIndex + 1, end);
        }
        return array;
    }

    /**
     * 快速排序算法——partition
     *
     * @param array
     * @param start
     * @param end
     * @return
     */
    public static int partition(int[] array, int start, int end) {
        int pivot = (int) (start + Math.random() * (end - start + 1));
        int smallIndex = start - 1;
        swap(array, pivot, end);
        for (int i = start; i <= end; i++) {
            if (array[i] <= array[end]) {
                smallIndex++;
                if (i > smallIndex) {
                    swap(array, i, smallIndex);
                }
            }
        }
        return smallIndex;
    }

    /**
     * 交换数组内两个元素
     *
     * @param array
     * @param i
     * @param j
     */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public static void myShort(){
        int[] arr = {1, 3, 2, 5, 4, 7, 6};
        int chushizhiIndex = 0;
        int chushizhi = arr[chushizhiIndex];
    }
}
