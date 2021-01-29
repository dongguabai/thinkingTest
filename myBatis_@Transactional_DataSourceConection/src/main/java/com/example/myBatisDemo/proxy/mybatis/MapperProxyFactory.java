package com.example.myBatisDemo.proxy.mybatis;

import com.google.common.collect.Lists;

import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Dongguabai
 * @Description 代理工厂
 * @Date 创建于 2021-01-26 19:18
 */
public class MapperProxyFactory<T> {

    Map<String, MapperProxy.Function> methodCache = new ConcurrentHashMap<>();

    private Class<T> mapperInterface;

    public MapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
        init();
    }

    protected T newInstance(MapperProxy<T> mapperProxy) {
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[]{mapperInterface}, mapperProxy);
    }

    public T newInstance() {
        final MapperProxy<T> mapperProxy = new MapperProxy<>(mapperInterface, methodCache);
        return newInstance(mapperProxy);
    }

    private void init() {
        //todo load Xml & Annotation
        methodCache.putIfAbsent("deleteById", o -> {
            System.out.printf("删除 ID 为【%s】的数据\n", o);
            return 1;
        });
        methodCache.putIfAbsent("selectAll", o -> Lists.newArrayList("a", "b", "c"));
    }

}
