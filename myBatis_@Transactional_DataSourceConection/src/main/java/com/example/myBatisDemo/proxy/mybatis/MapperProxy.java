package com.example.myBatisDemo.proxy.mybatis;

import org.springframework.util.Assert;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2021-01-26 19:01
 */
public class MapperProxy<T> implements InvocationHandler {

    private Class<T> mapperInterface;

    private Map<String, Function> methodCache;


    public MapperProxy(Class<T> mapperInterface, Map<String, Function> methodCache) {
        this.mapperInterface = mapperInterface;
        this.methodCache = methodCache;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("MapperProxy .invoke.....");
        Function function = methodCache.get(method.getName());
        Assert.notNull(function, "method not found...");
        return function.apply(args);
    }

    @FunctionalInterface
    interface Function{
        Object apply(Object[] t);
    }


}
