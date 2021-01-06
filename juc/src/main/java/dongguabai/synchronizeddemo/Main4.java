package dongguabai.synchronizeddemo;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2021-01-04 10:23
 */
public class Main4 {

    static int i;

    public static synchronized void m(){
        i++;
    }

    public static void main(String[] args) {
        m();
    }
}
