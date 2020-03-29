package com.demo.threadlocal;

import lombok.AllArgsConstructor;

import javax.annotation.security.RunAs;

/**
 * @author 魏民
 * @Description 执行任务包装类
 * @Date 创建于 2020-03-29 14:51
 */
public class MyTask implements Runnable {

    private Runnable runnable;

    private Integer inheritableValue;

    @Override
    public void run() {
        try {
            InheritableThreadLocalTest.HOLDER.set(inheritableValue);
            runnable.run();
        }finally {
            InheritableThreadLocalTest.HOLDER.remove();
        }
    }

    public MyTask(Runnable runnable) {
        this.runnable = runnable;
        this.inheritableValue =  InheritableThreadLocalTest.HOLDER.get();
    }
}
