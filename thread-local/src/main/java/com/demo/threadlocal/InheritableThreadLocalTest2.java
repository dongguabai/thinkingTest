package com.demo.threadlocal;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.TtlRunnable;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * @author 魏民
 * @Description
 * @Date 创建于 2020-03-29 20:43
 */
public class InheritableThreadLocalTest2 {

    //public static final InheritableThreadLocal<Integer> HOLDER = new InheritableThreadLocal<>();
    public static final TransmittableThreadLocal<Integer> HOLDER = new TransmittableThreadLocal<>();

    private static final ExecutorService FIXED_EXECUTOR = Executors.newFixedThreadPool(2);

    public static void main(String[] args) throws InterruptedException {
        FIXED_EXECUTOR.submit(() -> System.out.println("ready..."));
        Thread.sleep(20);
        HOLDER.set(1);
        print();
        Runnable task = InheritableThreadLocalTest2::print;
        // 额外的处理，生成修饰了的对象ttlRunnable
        TtlRunnable ttlRunnable = TtlRunnable.get(task);
        IntStream.range(0, 5).forEach(i -> {
            new Thread(ttlRunnable, "simple task").start();
            FIXED_EXECUTOR.submit(ttlRunnable);
        });
        FIXED_EXECUTOR.shutdown();
    }

    private static void print() {
        System.out.println(currentName() + ":" + HOLDER.get());
    }

    private static String currentName() {
        return Thread.currentThread().getName();
    }

}
