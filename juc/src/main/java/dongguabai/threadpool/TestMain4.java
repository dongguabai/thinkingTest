package dongguabai.threadpool;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2020-11-29 17:23
 */
public class TestMain4 {

    public static void main(String[] args) {
        final long l = System.currentTimeMillis();
        System.out.println(l);
        workTime(30000);
        System.out.println(System.currentTimeMillis());
    }

    private static void workTime(long ms) {
        final long l = System.currentTimeMillis();
        while (System.currentTimeMillis() <= l + ms) {
        }
    }
}
