package dongguabai.demo.netty.nio;

/**
 * @author dongguabai
 * @date 2019-04-11 10:42
 */
public class Test {

    static int mark = -1;
    public static void main(String[] args) {
        int position = 0;

        position = mark;
        System.out.println(mark);
        System.out.println(position);
        position = 11;
        System.out.println(mark);
        System.out.println(position);
    }
}
