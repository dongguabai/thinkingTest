package dongguabai.demo.juc.future.demo;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2021-01-07 00:35
 */
public class FutureTaskDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService service = Executors.newFixedThreadPool(1);
        final Future<Object> submit = service.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                System.out.println(new Date().toLocaleString() + "--开始执行");
                Thread.sleep(5000);
                System.out.println(new Date().toLocaleString() + "--执行完成");
                return "OK";
            }
        });


        Thread.sleep(4000);
        try {
            final Object o = submit.get(2, TimeUnit.SECONDS);
            System.out.println();
        } catch (TimeoutException e) {
            System.out.println(new Date().toLocaleString() + "--超时了");
        }
        service.shutdown();
    }
}
