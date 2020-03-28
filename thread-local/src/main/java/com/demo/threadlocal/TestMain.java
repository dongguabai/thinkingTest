package com.demo.threadlocal;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * @author 魏民
 * @Description
 * @Date 创建于 2020-03-28 16:57
 */
public class TestMain {

    private static AtomicInteger nextHashCode =
            new AtomicInteger();

    private static final int HASH_INCREMENT = 0x61c88647;

    private static final int INITIAL_CAPACITY = 16;


    /**
     * Returns the next hash code.
     */
    private static int nextHashCode() {
        return nextHashCode.getAndAdd(HASH_INCREMENT);
    }

    public static void main(String[] args) {
        ThreadLocal t1 = new ThreadLocal();
        IntStream.range(1,16).forEach(i-> System.out.println(nextHashCode() & (i - 1)));
    }
}
