package com.example.myBatisDemo.proxy;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2021-01-26 12:54
 */
public class Main1 {

    public static void main(String[] args) {
        ITarget target = new TargetImpl();
        ITarget proxy = new TargetProxy(target);
        proxy.show();
    }
}
