package demo.dongguabai.guava.eventbus.asyncEventBus2;

import com.google.common.eventbus.Subscribe;

import java.time.LocalDateTime;

/**
 * @author dongguabai
 * @date 2019-03-18 18:09
 * ExceptionListener1
 */
public class Listener1 {

    @Subscribe  //监听 参数为 String 的消息
    public void doSth0(String info) {
        System.out.println(LocalDateTime.now()+"   方法0 执行完毕");
    }



    @Subscribe  //监听 参数为 String 的消息
    public void doSth1(String info) {
        System.out.println(LocalDateTime.now()+"   方法1 执行开始");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(LocalDateTime.now()+"   方法1 执行完毕");
    }

    @Subscribe  //监听 参数为 String 的消息
    public void doSth2(String info) {
        System.out.println(LocalDateTime.now()+"   方法2 执行开始");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(LocalDateTime.now()+"   方法2 执行完毕");
    }

    @Subscribe  //监听 参数为 String 的消息
    public void doSth3(String info) {
        System.out.println(LocalDateTime.now()+"   方法3 执行开始");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(LocalDateTime.now()+"   方法3 执行完毕");
    }

    @Subscribe  //监听 参数为 String 的消息
    public void doSth4(String info) {
        System.out.println(LocalDateTime.now()+"   方法4 执行开始");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(LocalDateTime.now()+"   方法4 执行完毕");
    }
}
