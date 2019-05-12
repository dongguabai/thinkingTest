package dongguabai.demo.testing.classfield;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * @author 魏民
 * @Description
 * @Date 创建于 2019-05-06 18:24
 */
public class TestMain {
    public static void main(String[] args) {
        Field[] declaredFields = Son.class.getDeclaredFields();
        Arrays.stream(declaredFields).forEach(field -> System.out.println(field.getName()));
    }
}
