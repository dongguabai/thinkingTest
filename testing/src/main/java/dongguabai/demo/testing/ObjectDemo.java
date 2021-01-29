package dongguabai.demo.testing;

import org.testng.collections.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dongguabai
 * @Description
 * @Date 创建于 2021-01-13 15:40
 */
public class ObjectDemo {

    public static void main(String[] args) {

        Object o1 = (Object) "a";

        final List idList = getIdList();
        final Object o = idList.get(0);

        idList.get(0);

        final List<String> stringList = getStringList();
        final Object s = stringList.get(0);
    }

    public static List getIdList(){
        return Lists.newArrayList(1,2,3);
    }

    public static List<String> getStringList(){
        return Lists.newArrayList("a");
    }
}
