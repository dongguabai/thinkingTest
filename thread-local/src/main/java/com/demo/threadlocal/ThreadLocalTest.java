package com.demo.threadlocal;

import java.util.Date;

/**
 * @author 魏民
 * @Description
 * @Date 创建于 2020-03-28 13:58
 */
public class ThreadLocalTest {

    private static final ThreadLocal<Integer> HOLDER = ThreadLocal.withInitial(() -> 0);

    private static final ThreadLocal<Integer> HOLDER2 = ThreadLocal.withInitial(() -> 0);

    public static void main(String[] args) {
        /*HOLDER.set(1);
        System.out.println(getName()+"-HOLDER"+HOLDER.get());
        System.out.println(getName()+"-HOLDER2"+HOLDER2.get());*/

        User user = new User();

        Date birthday = user.getBirthday();
        birthday = new Date();
        System.out.println(birthday);

    }

    private static String getName() {
        return Thread.currentThread().getName();
    }
}
