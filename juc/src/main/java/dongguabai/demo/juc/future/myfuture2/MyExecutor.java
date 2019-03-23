package dongguabai.demo.juc.future.myfuture2;

import java.util.concurrent.Callable;

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

    public MyFuture<V> submit(){
       return submit(futureTask);
    }

    public MyFuture<V> submit(MyCallback<V> callback){
        return submit(futureTask,callback);
    }

    public MyFuture<V> submit(MyFutureTask<V> futureTask) {
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

    public MyFuture<V> submit(MyFutureTask<V> futureTask,MyCallback<V> callback) {
        if (futureTask ==null){
            return myFuture;
        }

        new Thread(
                () -> {
                    V result = null;
                    try {
                        result = futureTask.call();
                        complete(myFuture,result);
                        callback.callback(result);
                    } catch (Exception e) {
                        System.out.println("任务执行异常...");
                        e.printStackTrace();
                        complete(myFuture,null);
                    }
                }
        ).start();

        return myFuture;
    }

    private void complete(MyFuture myFuture, V result){
        myFuture.complete(result);
    }
}
