package dongguabai.demo.jvm.classloader;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author dongguabai
 * @date 2019-03-22 15:27
 */
public class ObjectDemo {

    public static void main(String[] args) throws InterruptedException {
           while (true){
               Thread.sleep(2000);
               String[] arry = new String[100];
               System.out.println(LocalDateTime.now()+"  ----");
           }
        }

}
