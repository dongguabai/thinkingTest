package dongguabai.demo.javadeep.deep11;

import java.util.concurrent.Callable;

/**
 * @author dongguabai
 * @date 2019-04-03 14:35
 */
public class InnerClassDemo {
    //静态代码块
    static {
        new Runnable() {
            @Override
            public void run() {

            }
        };
    }

    {
        new Callable<String>() {
            @Override
            public String call() throws Exception {
                return null;
            }
        };
    }
}
