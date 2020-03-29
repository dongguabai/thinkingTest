package com.demo.threadlocal;

/**
 * @author 魏民
 * @Description
 * @Date 创建于 2020-03-29 13:49
 */
public class InheritableThreadLocalTest {

    public static final ThreadLocal<Integer> HOLDER = new ThreadLocal<>();

    public static void main(String[] args) {
        HOLDER.set(1);
        System.out.println(currentName() + ":" + HOLDER.get());
        Runnable task = ()-> System.out.println(currentName()+":"+HOLDER.get());
        new Thread(task,"simple task").start();

        new Thread(new MyTask(task),"inheritable task").start();
    }

    private static String currentName() {
        return Thread.currentThread().getName();
    }
}
