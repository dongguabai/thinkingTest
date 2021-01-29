package com.example.myBatisDemo.proxy.jdk;

import com.example.myBatisDemo.proxy.ITarget;
import com.example.myBatisDemo.proxy.TargetImpl;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2021-01-26 13:02
 */
public class Main2 {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        //动态代理时生成class文件
        ITarget target = new TargetImpl();
        JdkProxyBuilder<ITarget> proxyBuilder = new JdkProxyBuilder<>(target);
        ITarget proxy = proxyBuilder.buildProxy();
        proxy.show();
        saveProxyFile();
    }


    private static void saveProxyFile() {
        FileOutputStream out = null;
        try {
            byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy0", TargetImpl.class.getInterfaces());
            out = new FileOutputStream("/Users/dongguabai/Desktop/temp/$Proxy0.class");
            out.write(classFile);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.flush();
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
