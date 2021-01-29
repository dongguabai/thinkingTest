package dongguabai.demo.juc.future.myfuture1;

import com.google.common.collect.ImmutableList;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author dongguabai
 * @date 2019-03-24 00:19
 * 执行者
 */
public class MyExecutor<V> {

    private MyFuture<V> myFuture = new MyFuture<V>();
    private MyFutureTask<V> futureTask = null;

    public MyExecutor(MyFutureTask<V> futureTask) {
        this.futureTask = futureTask;
    }

    public  MyFuture<V> submit(){
       return submit(futureTask);
    }

    public  MyFuture<V> submit(MyFutureTask<V> futureTask) {
        if (futureTask ==null){
            return myFuture;
        }

        new Thread(
                () -> {
                    V result = null;
                    try {
                        result = futureTask.call();
                        complete(myFuture,result);
                    } catch (Exception e) {
                        System.out.println("任务执行异常...");
                        e.printStackTrace();
                        complete(myFuture,null);
                    }
                }
        ).start();

        return myFuture;
    }

    private void complete(MyFuture myFuture,V result){
        myFuture.complete(result);
    }


    public static void main(String[] args) {
        Map<Integer, Map<Integer,String>> map = new HashMap<>();
        for (int i = 10; i < 20; i++) {
            Map<Integer, String> integerStringMap = map.computeIfAbsent(i, k -> new HashMap<>());
            for (int j = i; j >=0 ; j--) {
                integerStringMap.put(j,""+j);
            }
        }
        System.out.println(map);
        System.out.println("=================");
        for(Integer serviceName : map.keySet()) {
            Map<Integer, String> serviceInstanceMap =
                    map.get(serviceName);

            for(String serviceInstance : serviceInstanceMap.values()) {
               if(Integer.valueOf(serviceInstance)%2==0){
                   Map<Integer, String> smap = map.get(serviceName);
                   smap.remove(Integer.valueOf(serviceInstance));
               }
            }
        }
    }
}
