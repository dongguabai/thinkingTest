package dongguabai.algorithm.bobo;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Stream;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2021-01-06 16:54
 */
public class SortDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
       /* Integer[] arr = {2, 1, 5, 3, 8, 6, 4, 5, 0, 9, 1};
        insertSort1(arr);
        System.out.println("正确顺序：\n0 1 1 2 3 4 5 5 6 8 9 ");
        Stream.of(arr).forEach(a -> System.out.print(a + " "));

        System.out.println("\n=============");
        Integer[] arr2 = {2, 1, 5, 3, 8, 6, 4, 5, 0, 9, 1};
        insertSort2(arr2);
        System.out.println("正确顺序：\n0 1 1 2 3 4 5 5 6 8 9 ");
        Stream.of(arr2).forEach(a -> System.out.print(a + " "));*/

        ExecutorService service = Executors.newFixedThreadPool(10);
        final Future<Object> submit = service.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                System.out.println(new Date().toLocaleString()+"--开始执行");
                Thread.sleep(5000);
                System.out.println(new Date().toLocaleString()+"--执行完成");
                return "OK";
            }
        });


        Thread.sleep(4000);
        try {
            final Object o = submit.get(2, TimeUnit.SECONDS);
            System.out.println();
        } catch (TimeoutException e) {
            System.out.println(new Date().toLocaleString()+"--超市了");
        }
    }

    private static void insertSort1(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int t = arr[i];
            int j;
            for (j = i; j >= 1 && t < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = t;
        }
    }

    private static void insertSort2(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int t = arr[i];
            int j;
            for (j = i; j >= 1; j--) {
                if (t < arr[j - 1]) {
                    arr[j] = arr[j - 1];
                }
            }
            arr[j] = t;

        }
    }
}
