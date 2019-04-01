package demo.dongguabai.guava.eventbus.deadEvent;

import com.google.common.eventbus.EventBus;

/**
 * @author dongguabai
 * @date 2019-03-18 18:15
 */
public class DeadEventEventBusSource {

    public static void main(String[] args) {
        EventBus eventBus = new EventBus();
        DeadEventListener listener = new DeadEventListener();
        eventBus.register(listener);
        eventBus.post("EventBus 发送的 String 消息");
        System.out.println("准备移除----");
        eventBus.unregister(listener);
        eventBus.post("-----EventBus 发送的 String 消息");
    }
}
