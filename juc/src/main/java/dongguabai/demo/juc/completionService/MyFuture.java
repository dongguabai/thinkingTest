package dongguabai.demo.juc.completionService;

import java.util.concurrent.*;

/**
 * @author dongguabai
 * @date 2019-03-22 23:38
 */

//todo 公众号
public class MyFuture<V> {

    //状态标志
    private volatile boolean state = false;

    private V result;

    public synchronized V get() throws InterruptedException {
        while (!state){
           wait();
        }
        return result;
    }

}
