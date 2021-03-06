package com.demo.threadlocal;

import com.alibaba.ttl.TransmittableThreadLocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 魏民
 * @Description  引用类型是可以互相被影响的
 * @Date 创建于 2020-03-30 00:04
 */
public class TransmittableThreadLocalTest2 {

    public static final TransmittableThreadLocal<Integer> TTL_HOLDER = new TransmittableThreadLocal<>();
    public static final InheritableThreadLocal<User> ITL_HOLDER = new InheritableThreadLocal<>();
    public static final ThreadLocal<Integer> TL_HOLDER = new ThreadLocal<>();

    private static final ExecutorService FIXED_EXECUTOR = Executors.newFixedThreadPool(2);

        //子线程不影响父线程
    public static void main(String[] args) {
       // TTL_HOLDER.set(1);
       /* TL_HOLDER.set(2);
        TransmittableThreadLocal.Transmitter.registerThreadLocalWithShadowCopier(TL_HOLDER);
        System.out.println(TTL_HOLDER.get());
        Runnable task = InheritableThreadLocalTest2::print;
        // 额外的处理，生成修饰了的对象ttlRunnable
        TtlRunnable ttlRunnable = TtlRunnable.get(task);*/
       User user = new User();
       user.setName("zhangsan");
        ITL_HOLDER.set(user);
        FIXED_EXECUTOR.submit(()->{
            System.out.println(currentName()+"第一次获取："+ITL_HOLDER.get());
            sleep(2000);
            System.out.println(currentName()+"第二次获取："+ITL_HOLDER.get());
        });
        FIXED_EXECUTOR.submit(()->{
           sleep(100);
            User user1 = ITL_HOLDER.get();
            user1.setName("lisi");
            //ITL_HOLDER.set(user1);
            System.out.println(currentName()+"设置为："+ITL_HOLDER.get());
        });
        sleep(3000);
        System.out.println(ITL_HOLDER.get());

    }


    private static String currentName() {
        return Thread.currentThread().getName();
    }


    private static void sleep(long l){
        try {
            Thread.sleep(l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
