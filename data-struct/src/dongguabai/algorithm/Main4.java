package dongguabai.algorithm;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2020-12-29 11:00
 */

public class Main4 {

    private static volatile boolean finish = true;


    public static void main(String[] args) throws InterruptedException {

        new Thread(()->{
            while (finish){

            }
            System.out.println("end");
        }).start();
        Thread.sleep(5000);
        finish = false;
    }
}


