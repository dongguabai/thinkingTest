package dongguabai.threadpool;

/**
 * @author Dongguabai
 * @Description 拒绝策略
 * @Date 创建于 2020-11-29 11:47
 */
public interface MyRejectedExecutionHandler {

    void rejectedExecution(Runnable r, AbstractThreadPool executor);
}
