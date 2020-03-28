package com.demo.threadlocal;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 魏民
 * @Description
 * @Date 创建于 2020-03-28 10:11
 */
public class MyThreadLocal<T> extends ThreadLocal<T>{

    private final Map<Thread,T> HOLDER = new ConcurrentHashMap<>();

    @Override
    public T initialValue() {
        return null;
    }

    @Override
    public final T get() {
        Thread t = Thread.currentThread();
        T value = HOLDER.get(t);
        if (value == null){
            return initialValue();
        }
        return value;
    }

    @Override
    public final void set(T value) {
        HOLDER.put(Thread.currentThread(),value);
    }

    @Override
    public final void remove() {
        HOLDER.remove(Thread.currentThread());
    }
}
