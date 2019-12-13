package demo.dongguabai.guava.justTest.eventbus.asyncEventBus;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;

import java.util.concurrent.Executors;

/**
 * @author dongguabai
 * @date 2019-03-18 18:15
 */
public class EventBusSource {

    public static void main(String[] args) {
        EventBus eventBus = new AsyncEventBus(Executors.newFixedThreadPool(10));
        eventBus.register(new Listener1());
        eventBus.post("EventBus 发送的 String 消息");
    }
}
