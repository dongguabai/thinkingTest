package com.example.myBatisDemo.proxy;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2021-01-26 12:47
 */
public class TargetProxy implements ITarget{

    /**
     * 持有目标引用
     */
    private ITarget target;

    public TargetProxy(ITarget target) {
        this.target = target;
    }

    @Override
    public void show() {
        System.out.println("before......");
        target.show();
        System.out.println("after......");
    }
}
