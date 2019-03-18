package demo.dongguabai.guava.eventbus.demo1;

import com.google.common.eventbus.Subscribe;

import java.util.Date;

/**
 * @author dongguabai
 * @date 2019-03-18 18:09
 * 观察者 1
 */
public class Observer2 {

    @Subscribe  //监听 参数为 Date 的消息
    public void doSth(Date info){
        System.out.println("Observer2 接收到了消息："+info.toLocaleString());
    }
}
