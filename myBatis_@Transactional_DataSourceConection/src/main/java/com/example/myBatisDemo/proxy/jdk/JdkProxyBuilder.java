package com.example.myBatisDemo.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2021-01-26 13:00
 */
public class JdkProxyBuilder<T> implements InvocationHandler {

    private T target;

    public JdkProxyBuilder(T target) {
        this.target = target;
    }

    public T buildProxy(){
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before......");
        Object result = method.invoke(target, args);
        System.out.println("after......");
        return result;
    }
}
