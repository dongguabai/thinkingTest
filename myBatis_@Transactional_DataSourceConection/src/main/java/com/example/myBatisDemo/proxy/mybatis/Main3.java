package com.example.myBatisDemo.proxy.mybatis;

import java.util.List;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2021-01-26 19:17
 */
public class Main3 {

    public static void main(String[] args) {
        MapperProxyFactory<TestMapper> factory = new MapperProxyFactory<>(TestMapper.class);
        TestMapper mapper = factory.newInstance();
        int deleteLine = mapper.deleteById(123L);
        List<String> all = mapper.selectAll();

        System.out.printf("deleteById->result:[%s]\n",deleteLine);
        System.out.printf("selectAll->result:[%s]\n",all);
    }
}
