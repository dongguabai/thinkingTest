package com.example.myBatisDemo.proxy;

/**
 * @author Dongguabai
 * @Description 目标对象
 * @Date 创建于 2021-01-26 12:47
 */
public class TargetImpl implements ITarget{

    @Override
    public void show() {
        System.out.println("目标对象 show .....");
    }
}
