package dongguabai.algorithm.bobo;

import java.util.stream.Stream;

/**
 * @author Dongguabai
 * @Description 插入排序
 * @Date 创建于 2021-01-06 14:14
 */
public class InsertSort {

    public static void main(String[] args) {

       /* Integer[] arr = {2, 1, 5, 3, 8, 6, 4, 5, 0, 9, 1};
        insertSort4(arr);
        System.out.println("0 1 1 2 3 4 5 5 6 8 9 ");
        Stream.of(arr).forEach(a -> System.out.print(a + " "));*/

        System.out.println("=============");
        Integer[] arr2 = {2, 1, 5, 3, 8, 6, 4, 5, 0, 9, 1};
        insertSort7(arr2);
        System.out.println("0 1 1 2 3 4 5 5 6 8 9 ");
        Stream.of(arr2).forEach(a -> System.out.print(a + " "));
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
     *
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


    /**
     * 交换也是一个很复杂的操作可以直接赋值操作（错误）
     *
     * @param arr
     */
    private static void insertSort4(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            //变量存储要插入的那个元素值
            int todoCunChu = arr[i];
            int j;
            for (j = i; j >= 1; j--) {
                if (todoCunChu < arr[j - 1]) {
                    //如果要插入的元素比前一个元素小，那么就将前一个元素向后移动
                    arr[j] = arr[j - 1];
                }
            }
            System.out.println(j);
            arr[j] = todoCunChu;

        }
    }


    private static void insertSort5(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            //变量存储要插入的那个元素值
            int todoCunChu = arr[i];
            int j;
            for (j = i; j >= 1 && todoCunChu < arr[j - 1]; j--) {
                //如果要插入的元素比前一个元素小，那么就将前一个元素向后移动
                arr[j] = arr[j - 1];
            }
            arr[j] = todoCunChu;
        }
    }

    /**
     * insertSort5换个顺序遍历排序
     *
     * 循环不变量：后面都是排好序了的
     *
     * 倒着排，就要，先选定一个元素，依次与后面（索引+1）的元素进行比较，如果后面的元素更小，后面的元素，向左移动，继续比较
     * @param arr
     */
    private static void insertSort6(Integer[] arr) {
        for (int i = arr.length -2; i >=0; i--) {
            int temp = arr[i];
            int j;
            for ( j = i; j <arr.length-1 && arr[j+1]<temp; j++) {
                arr[j] = arr[j+1];
            }
            arr[j] = temp;
        }
    }

    /**
     * 倒着排，比较
     * @param arr
     */
    private static void insertSort7(Integer[] arr) {
        for (int i = arr.length -2; i >=0 ; i--) {
            for (int j = i; j < arr.length-1; j++) {
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}

