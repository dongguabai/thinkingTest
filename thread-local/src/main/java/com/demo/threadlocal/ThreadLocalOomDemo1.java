package com.demo.threadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 魏民
 * @Description
 * @Date 创建于 2020-04-06 01:38
 */
public class ThreadLocalOomDemo1 {

    private static final ExecutorService FIXED_EXECUTOR = Executors.newFixedThreadPool(1);

    public static void main(String[] args)  {

        FIXED_EXECUTOR.submit(() -> {
            ThreadLocal<String> threadLocal = new ThreadLocal<String>(){
                @Override
                protected void finalize() {
                    System.out.println("finalize........");
                }
            };
            threadLocal.set("a");
            System.out.println(threadLocal.get());
        });
        System.out.println("-------------------");
        sleep(100);
        System.gc();
        FIXED_EXECUTOR.submit(()->{
            Thread thread = Thread.currentThread();
            System.out.println(thread.getName());
        });
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
