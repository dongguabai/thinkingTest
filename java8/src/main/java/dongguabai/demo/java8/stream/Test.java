package dongguabai.demo.java8.stream;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 魏民
 * @Description
 * @Date 创建于 2019-04-30 12:10
 */
public class Test {

    public static void main(String[] args) {
        List<User> list = Lists.newArrayList(new User("1","张三"),new User("2","李四"),new User("3","王五"));
        Stream<User> stream = list.stream();
        List<String> collect = stream.map(user -> user.getId()).collect(Collectors.toList());
        List<String> collect2 = stream.map(user -> user.getId()).collect(Collectors.toList());
        collect.forEach(System.out::println);
        collect2.forEach(System.out::println);

    }
}
