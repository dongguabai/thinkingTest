package dongguabai.demo.juc.threadpool;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author dongguabai
 * @date 2019-03-20 11:58
 *
 * 内置线程池分析
 */
public class Demo3 {

    public static void main(String[] a) throws InterruptedException, IOException {
        System.out.println(Runtime.getRuntime().availableProcessors());
        ExecutorService executorService = Executors.newWorkStealingPool();

        List<Callable<String>> list = IntStream.range(0, 10).boxed().map(callable -> (Callable<String>) Demo3::doTask).collect(Collectors.toList());

        executorService.invokeAll(list).forEach(stringFuture -> {
            String s = null;
            try {
                s = stringFuture.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
            System.out.println(s);
        });
        System.out.println("000000");

    }

    static String doTask(){
        try {
            System.out.println(Thread.currentThread().getName()+ "正在执行！");
            TimeUnit.SECONDS.sleep(2);
            return Thread.currentThread().getName()+"  执行完毕！";
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void useSingleThreadExecutor() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
    }

    private static void useFiexdThreadPool() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
    }

    private static void useCachedThreadPoolExecutor() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10000; i++) {
            executorService.execute(()->{
                String[] arr = new String[10000];
                System.out.println(Thread.currentThread().getName()+"正在执行....");
            });
        }
    }
}
