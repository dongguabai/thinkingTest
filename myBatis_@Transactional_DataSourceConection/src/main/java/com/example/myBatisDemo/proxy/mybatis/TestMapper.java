package com.example.myBatisDemo.proxy.mybatis;

import java.util.List;

/**
 * @author Dongguabai
 * @Description 被代理接口
 * @Date 创建于 2021-01-26 13:46
 */
public interface TestMapper {

    int deleteById(Long id);

    List<String> selectAll();
}
