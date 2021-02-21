package dongguabai.atomic;

/**
 * @author Dongguabai
 * @description
 * @date 2021-02-21 21:33
 */
public class Main2 {

    public static void main(String[] args) {
        Object o = new Object();

        synchronized (o){
            o = null;

            synchronized (o){
            }
        }
    }
}
