package dongguabai.demo.juc.future.completionService;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author dongguabai
 * @date 2019-03-21 16:51
 */
public class FutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("开始执行-----");
        Future<String> future = Executors.newCachedThreadPool().submit(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("执行完毕----");
            return "success";
        });
        System.out.println("-----异步  "+ LocalDateTime.now());
        String s = future.get();
        System.out.println("----同步   "+LocalDateTime.now());
    }
}
