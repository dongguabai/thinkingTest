package dongguabai.demo.testing;

import dongguabai.demo.testing.classfield.Parent;
import org.apache.catalina.User;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author dongguabai
 * @date 2019-03-20 23:39
 */
public class Test1 {

    public static void main(String[] args) throws InterruptedException {
        Parent parent = new Parent();
        parent.setPassword("123");
        parent.setUsername("张三");

        Parent last = parent;
        System.out.println(parent);
        System.out.println(last);
        System.out.println("--------");
        last.setUsername("aaaa");

        System.out.println(parent);
        System.out.println(last);
    }

    private static void print(@NonNull String a){
        System.out.println(a);
    }
}
