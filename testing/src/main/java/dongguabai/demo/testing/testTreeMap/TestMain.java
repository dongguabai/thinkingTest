package dongguabai.demo.testing.testTreeMap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/**
 * @author 魏民
 * @Description
 * @Date 创建于 2019-08-25 10:48
 */
public class TestMain {

    public static void main(String[] args) {
        Map<User, String> map = new TreeMap<>(Comparator.comparing(User::getSeq));
        map.put(new User(1, "张一", 1), "a");
        map.put(new User(3, "张三", 3), "c");
        //map.put(new User(2, "张二", 2), "b");
        map.put(new User(2, "张二", 1), "b");
        map.forEach((k, v) -> System.out.println(k + "->" + v));
    }
}
