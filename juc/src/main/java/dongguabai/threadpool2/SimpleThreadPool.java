package dongguabai.threadpool2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2020-11-29 12:19
 */
public class SimpleThreadPool {

    private final int size;

    private final static int DEFAULT_SIZE = 10;

    private final static LinkedList<Runnable> TASK_QUEUE = new LinkedList<>();

    private final static List<WorkerTask> THREAD_QUEUE = new ArrayList<>();

    private volatile int seq = 0;

    private final static String THREAD_PREFIX = "SIMPLE_THREAD_POOL-";

    private final ThreadGroup GROUP = new ThreadGroup("Pool_Group");


    public SimpleThreadPool(int size) {
        this.size = size;
        init();
    }

    public SimpleThreadPool() {
        this(DEFAULT_SIZE);
    }

    private void init() {
        IntStream.range(0, size).forEach(i -> createWorkerTask());
    }

    private void createWorkerTask() {
        final WorkerTask workerTask = new WorkerTask(GROUP, THREAD_PREFIX + (seq++));
        workerTask.start();
        THREAD_QUEUE.add(workerTask);
    }

    public void submit(Runnable runnable){
        synchronized (TASK_QUEUE){
            TASK_QUEUE.addLast(runnable);
            TASK_QUEUE.notifyAll();
        }
    }

    private enum TaskState {
        FREE, RUNNING, BLOCKED, DEAD;
    }

    private class WorkerTask extends Thread {
        private volatile TaskState state;

        public TaskState getTaskState() {
            return state;
        }

        public WorkerTask(ThreadGroup group, String name) {
            super(group, name);
        }

        @Override
        public void run() {
            OUTER:
            while (getTaskState() != TaskState.DEAD) {
                Runnable runnable;
                synchronized (TASK_QUEUE) {
                    while (TASK_QUEUE.isEmpty()) {
                        try {
                            TASK_QUEUE.wait();
                        } catch (InterruptedException e) {
                            break OUTER;
                        }
                    }
                    runnable = TASK_QUEUE.removeFirst();
                }
                if (runnable != null) {
                    state = TaskState.RUNNING;
                    runnable.run();
                    state = TaskState.FREE;
                }
            }
        }
    }
}
