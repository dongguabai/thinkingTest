package dongguabai.demo.testing.objects;

import org.testng.annotations.Test;

import java.util.Objects;
import java.util.function.Supplier;

/**
 * @author 魏民
 * @Description
 * @Date 创建于 2019-04-28 09:38
 */
public class ObjectsTest {

    @Test
    public void test1(){
        String s = Objects.toString("aa", "default");
        System.out.println(s);

        System.out.println(Objects.toString(null,"de"));
    }

    @Test
    public void test2(){
        Objects.requireNonNull("aaaa", new Supplier<String>() {
            @Override
            public String get() {
                return "为null";
            }
        });
    }

    @Test
    public void test3(){
        System.out.println(Objects.deepEquals(null, null));
        System.out.println(Objects.deepEquals(new String[]{"a", "b"}, new String[]{"a", "b"}));
    }

}
