package dongguabai.demo.juc.future.myfuture2;

/**
 * @author dongguabai
 * @date 2019-03-24 00:23
 * 要执行的任务
 */
@FunctionalInterface
public interface MyFutureTask<V> {

    V call() throws Exception;
}
