package dongguabai.code.interview.single;

import java.util.concurrent.TimeUnit;

/**
 * @author dongguabai
 * @date 2019-03-19 11:07
 */
public class Code2 {

    private static volatile int count = 0;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            Thread a = new Thread(){
                @Override
                public void run() {
                    for (int j = 0; j < 2; j++) {
                        try {
                            TimeUnit.MILLISECONDS.sleep(50);
                            count++;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(count+(count!=10?",":""));
                    }
                }
            };
            a.start();
            //原题没有下面这一行代码
            a.join();
        }
    }
}
