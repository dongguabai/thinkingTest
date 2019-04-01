package demo.dongguabai.guava.eventbus.exception_demo2;

import com.google.common.eventbus.Subscribe;

/**
 * @author dongguabai
 * @date 2019-03-18 18:09
 * ExceptionListener1
 */
public class ExceptionListener1 {

    @Subscribe  //监听 参数为 String 的消息
    public void exceptionMethod(String info) {
        System.out.println("ExceptionListener1 接收到了消息：" + info);
        int i = 1/0;
    }
}
