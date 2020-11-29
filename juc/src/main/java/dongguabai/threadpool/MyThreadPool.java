package dongguabai.threadpool;

import org.apache.ibatis.datasource.pooled.PoolState;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2020-11-29 10:43
 */
public class MyThreadPool extends AbstractThreadPool {

    private final MyThreadFactory threadFactory;

    /**
     * workers
     */
    private final HashSet<MyWorker> workers = new HashSet<>();

    /**
     * tasks
     * todo
     */
    private final BlockingQueue<Runnable> workQueue;

    private final MyRejectedExecutionHandler rejectedExecutionHandler = new MyDefaultRejectedExecutionHandler();

    /**
     * 核心线程数
     */
    private volatile int corePoolSize = 10;

    /**
     * 最大线程数
     */
    private volatile int maxPoolSize = 20;

    private volatile PoolState poolState = PoolState.RUNNABLE;


    public MyThreadPool(int corePoolSize, int maxPoolSize) {
        this(new MyDefaultThreadFactory(), new ArrayBlockingQueue<>(20), corePoolSize, maxPoolSize);
    }

    public MyThreadPool(MyThreadFactory threadFactory, BlockingQueue<Runnable> workQueue, int corePoolSize, int maxPoolSize) {
        this.threadFactory = threadFactory;
        this.workQueue = workQueue;
        this.corePoolSize = corePoolSize;
        this.maxPoolSize = maxPoolSize;
    }

    private MyThreadFactory getThreadFactory() {
        return threadFactory;
    }

    @Override
    public int getPoolSize() {
        return workers.size();
    }

    @Override
    public void execute(Runnable command) {
        if (poolState == PoolState.TERMINATED){
            throw new RuntimeException("pool terminated....");
        }
        if (poolState == PoolState.SHUTDOWN){
            throw new RuntimeException("pool shutdown....");
        }
        final int poolSize = getPoolSize();
        if (corePoolSize > poolSize) {
            addWorker(command);
            return;
        }
        //任务队列添加数据
        final boolean offer = workQueue.offer(command);
        if (offer) {
            //数据添加成功
            return;
        }
        //满了
        if (poolSize < maxPoolSize) {
            addWorker(command);
            return;
        }
        rejectedExecutionHandler.rejectedExecution(command, this);
    }

    final void runWorker(MyWorker w) {

        Runnable firstTask = w.firstTask;
        if (firstTask != null) {
            runRunnable(firstTask);
        }
        Thread thread = w.thread;
        while (!workQueue.isEmpty()) {
            try {
                //System.out.println(Thread.currentThread().getName()+"阻塞了；"+workQueue.size());
                Runnable take = workQueue.take();
                //System.out.println(Thread.currentThread().getName()+"执行了；"+workQueue.size());
                runRunnable(take);
            } catch (InterruptedException e) {
                System.out.println("take....InterruptedException");
                break;
            }
        }

    }

    private void runRunnable(Runnable runnable) {
        beforeExecute(Thread.currentThread(), runnable);
        try {
            runnable.run();
            afterExecute(runnable, null);
        } catch (Throwable throwable) {
            afterExecute(runnable, throwable);
        }
    }

    /**
     * worker
     */
    private final class MyWorker implements Runnable {

        private final Thread thread;
        /**
         * Initial task to run.
         * Possibly null.
         */
        private final Runnable firstTask;

        /**
         * create
         */
        MyWorker(Runnable runnable) {
            this.firstTask = runnable;
            this.thread = getThreadFactory().newThread(this);
        }

        @Override
        public void run() {
            runWorker(this);
        }
    }

    public void prestartCoreThread() {
        if (getPoolSize() < corePoolSize) {
            addWorker(null);
        }
    }

    private void addWorker(Runnable firstTask) {
        MyWorker worker = new MyWorker(firstTask);
        Thread thread = worker.thread;
        thread.start();
        workers.add(worker);
    }

    /**
     *  等线程池中所有任务都执行完成才关闭线程池
     */
    public void shutDown(){
        poolState = PoolState.SHUTDOWN;
        while (!workQueue.isEmpty()){}
        for (MyWorker worker : workers) {
            Thread thread = worker.thread;
            thread.interrupt();
        }
        poolState = PoolState.TERMINATED;
        System.out.println("shutDown...finish...");
    }

    /**
     * 直接关闭
     */
    public void shutDownNow(){
        workQueue.clear();
        shutDown();
    }

    /**
     * default threadFactory
     */
    private static final class MyDefaultThreadFactory implements MyThreadFactory {
        private static final AtomicInteger POOL_NUMBER = new AtomicInteger(1);
        private final ThreadGroup group = new ThreadGroup("my_thread_pool_group");
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final static String NAME_PREFIX = "my_thread_pool-";

        private final String namePrefix;

        MyDefaultThreadFactory() {
            namePrefix = NAME_PREFIX + POOL_NUMBER.getAndIncrement() + "-thread-";
        }

        @Override
        public Thread newThread(@NotNull Runnable r) {
            Thread t = new Thread(group, r, namePrefix + threadNumber.getAndIncrement());
            //守护
            if (t.isDaemon()) {
                t.setDaemon(false);
            }
            //priority
            if (t.getPriority() != Thread.NORM_PRIORITY) {
                t.setPriority(Thread.NORM_PRIORITY);
            }
            return t;
        }
    }

    public static class MyDefaultRejectedExecutionHandler implements MyRejectedExecutionHandler {
        /**
         * Creates an {@code AbortPolicy}.
         */
        public MyDefaultRejectedExecutionHandler() {
        }

        @Override
        public void rejectedExecution(Runnable r, AbstractThreadPool executor) {
            throw new RuntimeException("Queue is full...");
        }
    }

    private enum PoolState{
        RUNNABLE,SHUTDOWN,TERMINATED
    }
}

