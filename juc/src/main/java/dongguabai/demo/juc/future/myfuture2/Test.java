package dongguabai.demo.juc.future.myfuture2;


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
        }).submit((result)->{
            System.out.println("获取执行结果为："+result+"   "+LocalDateTime.now());
        });
        System.out.println("我去做别的事情去了-----"+LocalDateTime.now());
    }
}
