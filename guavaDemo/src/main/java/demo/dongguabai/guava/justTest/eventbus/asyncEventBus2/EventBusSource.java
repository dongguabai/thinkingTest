package demo.dongguabai.guava.justTest.eventbus.asyncEventBus2;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.util.concurrent.MoreExecutors;

/**
 * @author dongguabai
 * @date 2019-03-18 18:15
 */
public class EventBusSource {

    public static void main(String[] args) {
        AsyncEventBus eventBus = new AsyncEventBus(MoreExecutors.directExecutor());
        eventBus.register(new Listener1());
        eventBus.post("EventBus 发送的 String 消息");
    }
}
