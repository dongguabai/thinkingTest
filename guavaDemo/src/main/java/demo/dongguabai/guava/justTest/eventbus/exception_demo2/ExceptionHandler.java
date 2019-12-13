package demo.dongguabai.guava.justTest.eventbus.exception_demo2;

import com.google.common.eventbus.SubscriberExceptionContext;
import com.google.common.eventbus.SubscriberExceptionHandler;

/**
 * @author dongguabai
 * @date 2019-04-01 13:21
 * 自定义异常处理
 */
public class ExceptionHandler implements SubscriberExceptionHandler {
    @Override
    public void handleException(Throwable exception, SubscriberExceptionContext context) {
        System.out.println("自定义异常处理....");
        System.out.println(exception.getLocalizedMessage());
        System.out.println("异常方法名称："+context.getSubscriberMethod().getName());
        System.out.println("异常方法参数："+context.getSubscriberMethod().getParameters()[0]);
    }
}
