package dongguabai.demo.netty;

import java.util.concurrent.TimeUnit;

/**
 * @author dongguabai
 * @date 2019-04-09 16:34
 */
public class Tests {

    public static void main(String[] args) {
        while (true){
            System.out.println("亮灯");
            System.out.println("熄灯");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
