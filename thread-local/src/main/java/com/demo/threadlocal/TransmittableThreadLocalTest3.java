package com.demo.threadlocal;

import com.alibaba.ttl.TransmittableThreadLocal;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 魏民
 * @Description
 * @Date 创建于 2020-03-31 15:58
 */
public class TransmittableThreadLocalTest3 {

    public static final TransmittableThreadLocal<List<String>> TTL_HOLDER = new TransmittableThreadLocal<>();
    // public static final InheritableThreadLocal<Integer> ITL_HOLDER = new InheritableThreadLocal<>();


    private static final ExecutorService FIXED_EXECUTOR = Executors.newSingleThreadExecutor();


    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
           /* List<String> list = new ArrayList<>();
            list.add("1");
            TTL_HOLDER.set(list);
            FIXED_EXECUTOR.submit(() -> System.out.println("----"));
            sleep20();
            print();*/
            FIXED_EXECUTOR.submit(() -> {
                /*print();
                List<String> list1 = TTL_HOLDER.get();
                list1.add("2");
                print();*/
                List<String> list2 = new ArrayList<>();
                list2.add("a");
                TTL_HOLDER.set(list2);
                print();
            });
            sleep20();
            print();
        }, "T1").start();
        sleep2000();
        new Thread(() -> {
            print();
            FIXED_EXECUTOR.submit(TransmittableThreadLocalTest3::print);
        }, "T2").start();
        sleep20();
        FIXED_EXECUTOR.shutdown();


    }

    private static void sleep2000() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
