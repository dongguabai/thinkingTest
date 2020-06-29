package dongguabai.demo.testing.enumtest;

import java.util.EnumSet;

/**
 * @author Dongguabai
 * @Description EnumSet
 * @Date 创建于 2020-06-29 16:09
 */
public class EnumSetTest {

    public static void main(String[] args) {
        EnumSet enumSet = EnumSet.allOf(Pizza.PizzaStatus.class);
    }
}
