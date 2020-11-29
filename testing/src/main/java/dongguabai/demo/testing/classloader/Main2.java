package dongguabai.demo.testing.classloader;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2020-11-22 01:38
 */
public class Main2 {
    public static void main(String[] args) {
        System.out.println(Person.str);
    }
}

class Person{

    public static final String str = "User_Str";

    static {
        System.out.println("User static....");
    }
}
