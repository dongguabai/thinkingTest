package dongguabai.demo.juc.blockingqueue;



import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author dongguabai
 * @date 2019-03-20 13:26
 */
public class ArrayBlockingQueueDemo {

    /**
     * add ：添加成功返回 true，如达到了 ArrayBlockingQueue 的 bounds，则抛出 IllegalStateException
     */
    @Test
    public void testAdd(){
        ArrayBlockingQueue<String> arrayBlockingQueue = createDefault();
        arrayBlockingQueue.add("a1");
        arrayBlockingQueue.add("a2");
        arrayBlockingQueue.add("a3");
        arrayBlockingQueue.add("a4");
        arrayBlockingQueue.add("a5");
        arrayBlockingQueue.add("a6");  //抛出异常
    }








    static ArrayBlockingQueue<String> create(int bounds){
        return new ArrayBlockingQueue<>(bounds);
    }

    static ArrayBlockingQueue<String> createDefault(){
        return create(5);
    }
}
