
package dongguabai.demo.juc.threadpool;

import java.util.concurrent.*;


/**
 * @author dongguabai
 * @date 2019-03-19 22:13
 */

public class Demo1 {


    public static void main(String[] args) {


/**
         * Creates a new {@code ThreadPoolExecutor} with the given initial
         * parameters.
         *
         * @param corePoolSize the number of threads to keep in the pool, even
         *        if they are idle, unless {@code allowCoreThreadTimeOut} is set
         *
         *        核心线程数，线程池会一直保持着这个数量的线程数，即使这些线程是闲着。除非
         *        allowCoreThreadTimeOut 从这个参数名称就可以看出来，允许核心线程数超时，
 *                该参数被设置为 true（默认是 false），核心线程数也会超时直到线程池中线程数为0
 *                在创建线程池之后，线程池默认没有任何线程。
 *
 *                线程池创建之后，线程池中的线程数为0（除非调用了prestartAllCoreThreads()或者prestartCoreThread()方法，
 *                从这2个方法的名字就可以看出，是预创建线程的意思，即在没有任务到来之前就创建corePoolSize个线程或者一个线程），
 *                当任务过来就会创建一个线程去执行，直到线程数达到corePoolSize 之后，就会被到达的任务放在队列中
         *
         *
         * @param maximumPoolSize the maximum number of threads to allow in the
         *        pool
         *
         *        线程池中线程的最大数量，当队列满了，会继续创建线程，但线程数量不能超过这个参数
         *
         * @param keepAliveTime when the number of threads is greater than
         *        the core, this is the maximum time that excess idle threads
         *        will wait for new tasks before terminating.
         *
         *        当线程数量超过了核心线程数，这个参数设置的时间超时后，会把多余的线程终止
         *
         * @param unit the time unit for the {@code keepAliveTime} argument
         *
         *         上面参数的单位
         *
         * @param workQueue the queue to use for holding tasks before they are
         *        executed.  This queue will hold only the {@code Runnable}
         *        tasks submitted by the {@code execute} method.
         *
         *        这个队列负责hold所有的task，也就是说所有的任务并不是直接执行的，而是先放到这个queue里面，
         *        除非任务被submit（即执行了 execute() 方法）
         *
         * @param threadFactory the factory to use when the executor
         *        creates a new thread
         *
         *        创建线程的factory
         *
         * @param handler the handler to use when execution is blocked
         *        because the thread bounds and queue capacities are reached
         *
         *        拒绝策略：当到达了线程数量当 bounds 且到达了 queue 的容量
         *
         * @throws IllegalArgumentException if one of the following holds:<br>
         *         {@code corePoolSize < 0}<br>
         *         {@code keepAliveTime < 0}<br>
         *         {@code maximumPoolSize <= 0}<br>
         *         {@code maximumPoolSize < corePoolSize}
         *
         *         说白了：0<= corePoolSize <= maximumPoolSize
         *
         * @throws NullPointerException if {@code workQueue}
         *         or {@code threadFactory} or {@code handler} is null
         */


  /*  public ThreadPoolExecutor(int corePoolSize,
        int maximumPoolSize,
        long keepAliveTime,
        TimeUnit unit,
        BlockingQueue<Runnable> workQueue,
        ThreadFactory threadFactory,
        RejectedExecutionHandler handler) {
          ...
          ...
        }
*/


    }

}