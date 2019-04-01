package demo.dongguabai.guava.eventbus.exception_demo2;

import com.google.common.eventbus.EventBus;

import java.util.Date;

/**
 * @author dongguabai
 * @date 2019-03-18 18:15
 */
public class ExceptionEventBusSource {

    public static void main(String[] args) {
        //传入自定义异常处理 Handler
        EventBus eventBus = new EventBus(new ExceptionHandler());
        eventBus.register(new ExceptionListener1());
        eventBus.register(new Listener2());
        eventBus.post("EventBus 发送的 String 消息");
        eventBus.post(new Date());
    }
}
