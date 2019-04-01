package demo.dongguabai.guava.eventbus.demo1;

import com.google.common.eventbus.Subscribe;

/**
 * @author dongguabai
 * @date 2019-03-18 18:09
 * ExceptionListener1
 */
public class Listener1 {

    @Subscribe  //监听 参数为 String 的消息
    public void doSth(String info) {
        System.out.println("ExceptionListener1 接收到了消息：" + info);
    }
}
