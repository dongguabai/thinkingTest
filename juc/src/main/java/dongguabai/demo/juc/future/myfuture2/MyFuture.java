package dongguabai.demo.juc.future.myfuture2;


/**
 * @author dongguabai
 * @date 2019-03-24 00:26
 */
public class MyFuture<V> {

    /**
     * 类似 FutureTask 中的 state
     */
    private volatile boolean completed;

    /**
     * 返回的结果
     */
    private V outcome;

    public synchronized V get() throws Exception {
        while (!completed) {
            wait();
        }
        return outcome;
    }

    synchronized void complete(V result) {
        outcome = result;
        completed = true;
        notifyAll();
    }
}
