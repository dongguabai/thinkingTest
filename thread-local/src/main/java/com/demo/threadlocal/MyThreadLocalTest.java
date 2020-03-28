package com.demo.threadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @author 魏民
 * @Description
 * @Date 创建于 2020-03-28 09:47
 */
public class MyThreadLocalTest {

    private static final MyThreadLocal<Integer> HOLDER = new MyThreadLocal<Integer>() {
        @Override
        public Integer initialValue() {
            return 0;
        }
    };

    private static final ExecutorService POOL = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        Runnable task = () -> IntStream.range(0, 10).forEach(i -> System.out.println(Thread.currentThread().getName() + "：" + nextInt()));
        POOL.submit(task);
        POOL.submit(task);

        POOL.shutdown();
    }

    private static Integer nextInt() {
        Integer value = HOLDER.get();
        value++;
        HOLDER.set(value);
        return value;
    }

}
