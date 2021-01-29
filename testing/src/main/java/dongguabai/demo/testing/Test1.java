package dongguabai.demo.testing;


import lombok.Data;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @author dongguabai
 * @date 2019-03-20 23:39
 */
public class Test1 {

    public static void main(String[] args) throws InterruptedException {

        User u1 = new User();
        u1.setName("zhangsn");

        ReferenceQueue<User> referenceQueue = new ReferenceQueue<>();

        WeakReference<User> weakReference = new WeakReference<>(u1,referenceQueue);

        u1 = null;

        System.gc();

        Thread.sleep(1000);

        System.out.println(weakReference.get());
        System.out.println(weakReference);
        System.out.println(referenceQueue.poll());
    }
}

@Data
class User{
    private String name;


}
