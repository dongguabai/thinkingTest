package demo.dongguabai.guava.eventbus.demo2;

import com.google.common.eventbus.EventBus;
import demo.dongguabai.guava.eventbus.demo1.Observer2;

import java.util.Date;

/**
 * @author dongguabai
 * @date 2019-03-18 18:15
 */
public class EventBusManager {

    public static void main(String[] args) {
        EventBus eventBus = new EventBus();
        eventBus.register(new Observer1());
        eventBus.register(new Observer2());
        eventBus.post("EventBus 发送的 String 消息");
        eventBus.post(new Date());
    }
}
