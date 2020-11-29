package dongguabai.threadpool;

import java.util.concurrent.Executor;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2020-11-29 11:17
 */
public abstract class AbstractThreadPool implements Executor {

    /**
     * Returns the current number of threads in the pool.
     *
     * @return
     */
    public abstract int getPoolSize();

    protected void afterExecute(Runnable r, Throwable t) {
    }

    protected void beforeExecute(Thread t, Runnable r) { }

}
