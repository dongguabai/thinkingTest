package dongguabai.demo.testing.classloader;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2020-11-22 01:01
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(int.class.isPrimitive());  //true
        System.out.println(Void.class.isPrimitive());  //false
        System.out.println(Integer.class.isPrimitive());  //false
    }
}
