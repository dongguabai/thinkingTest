package dongguabai.demo.juc.future.myfuture1;

import java.time.LocalDateTime;

/**
 * @author dongguabai
 * @date 2019-03-24 00:38
 */
public class Test {

    public static void main(String[] args) throws Exception {

        MyFuture<String> future = new MyExecutor<String>(() -> {
            System.out.println("开始执行----"+ LocalDateTime.now());
            int i = 1+1;
            Thread.sleep(2000);
            return i + "";
        }).submit();
        System.out.println("异步："+LocalDateTime.now());
        System.out.println("获取结果："+future.get()+"  "+LocalDateTime.now());
    }
}
