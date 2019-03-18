package demo.dongguabai.guava.eventbus.demo1;

import com.google.common.eventbus.Subscribe;

/**
 * @author dongguabai
 * @date 2019-03-18 18:09
 * 观察者 1
 */
public class Observer1 {

   // @Subscribe  //监听 参数为 String 的消息
    public void doSth(String info){
        System.out.println("Observer1 接收到了消息："+info);
    }
}
