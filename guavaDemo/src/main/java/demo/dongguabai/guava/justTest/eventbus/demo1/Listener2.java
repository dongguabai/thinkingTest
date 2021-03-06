package demo.dongguabai.guava.justTest.eventbus.demo1;

import com.google.common.eventbus.Subscribe;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author dongguabai
 * @date 2019-03-18 18:09
 * Listener2
 */
public class Listener2 {

    @Subscribe  //监听 参数为 Date 的消息
    public void doSth(Date info) {
        System.out.println(LocalDateTime.now()+"Listener2 接收到了消息：" + info.toLocaleString());
    }
}
