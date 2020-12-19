package dongguabai.synchronizeddemo;

        import org.openjdk.jol.info.ClassLayout;

/**
 * @author Dongguabai
 * @Description 无锁
 * @Date 创建于 2020-12-18 09:59
 */
public class Main2 {

    public static void main(String[] args) throws InterruptedException {
        Main2 main2 = new Main2();
        System.out.println(ClassLayout.parseInstance(main2).toPrintable());
    }
}
