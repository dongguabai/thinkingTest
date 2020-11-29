package dongguabai.demo.testing.classloader;

import java.util.Date;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2020-11-22 10:36
 */
public class Main4 {
    public static void main(String[] args) {
        System.out.println(Person2.str2);
    }
}

class Person2{

    public static final Date date = new Date();
    public static final String str2 = "a"+"b";
    static {
        System.out.println("User2 static....");
    }
}