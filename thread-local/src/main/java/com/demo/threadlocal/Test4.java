package com.demo.threadlocal;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.TtlRunnable;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 魏民
 * @Description
 * @Date 创建于 2020-04-05 17:58
 */
public class Test4 {

    public static final TransmittableThreadLocal<String> TTL_HOLDER = new TransmittableThreadLocal<>();

    private static final ExecutorService FIXED_EXECUTOR = Executors.newSingleThreadExecutor();

    public static void main(String[] args) {
        print();
        Runnable task = ()->{
            print();
            TTL_HOLDER.set(UUID.randomUUID().toString());
            print();
        };
        // 额外的处理，生成修饰了的对象ttlRunnable
        TtlRunnable ttlRunnable = TtlRunnable.get(task);
        new Thread(()-> FIXED_EXECUTOR.submit(ttlRunnable),"T!").start();
        sleep20();
        new Thread(()-> FIXED_EXECUTOR.submit(ttlRunnable),"T2").start();
        sleep20();
        print();
    }

    private static void sleep20() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void print() {
        System.out.println(Thread.currentThread().getName() + ":" + TTL_HOLDER.get());
    }
}
