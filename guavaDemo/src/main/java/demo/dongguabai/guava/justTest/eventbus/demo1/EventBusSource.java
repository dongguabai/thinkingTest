package demo.dongguabai.guava.justTest.eventbus.demo1;

import com.google.common.eventbus.EventBus;

import java.util.Date;

/**
 * @author dongguabai
 * @date 2019-03-18 18:15
 */
public class EventBusSource {

    public static void main(String[] args) {
        EventBus eventBus = new EventBus();
        eventBus.register(new Listener1());
        eventBus.register(new Listener2());
        eventBus.post("EventBus 发送的 String 消息");
        eventBus.post(new Date());
    }
}
