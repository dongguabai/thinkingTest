package dongguabai.demo.java8.stream;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author 魏民
 * @Description
 * @Date 创建于 2019-10-15 13:04
 */
public class Test2 {

    public static void main(String[] args) {
        String[] arr = {"-1", "-2", "1 ", "2", "1", "3", "4", " 3", "5", "6", "5"};

        List<String> list = Stream.of(arr)
                .skip(2)
                .map(StringUtils::trim)
                .collect(Collectors.toList())
                .stream().collect(Collectors.toMap(e -> e, e -> 1, (v1, v2) -> v1 + v2))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println(list);
        list.stream();
    }

    @Test
    public void test1() {
        List<String> list = Lists.newArrayList("a", "b");
        Stream<String> stream = list.stream();
        Stream<String> parallel = stream.parallel();
    }

    @Test
    public void test2() {
        //根据文件路径创建流
        try (Stream<String> lines = Files.lines(Paths.get("/Users/dongguabai/Desktop/temp/520.txt"))) {
            lines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test39(){
        IntStream.range(1,11).boxed().skip(5).forEach(System.out::print);
        System.out.println();
        IntStream.range(1,11).boxed().forEach(System.out::print);
    }

    @Test
    public void test3(){
        IntStream.range(1,11).forEach(System.out::print);
        System.out.println();
        //将 1-10 每个数字加 1
        IntStream.range(1,11).map(a->a+1).forEach(System.out::print);
    }

    @Test
    public void test4(){
        //获取所有 User 的用户名集合
        List<User> list = Lists.newArrayList(new User("1","张三"),new User("2","李四"),new User("3","王五"));
        List<String> collect = list.stream().map(User::getUsername).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    @Test
    public void test5(){
        List<User> list = Lists.newArrayList(new User("1","张三"),new User("2",null),new User("3","王五"));
        //获取一个 Map，key 是用户的 id，value 是用户的名称(这里有一个User对象的username是null)
        Map<String, String> map = list.stream().collect(HashMap::new, (m, v) -> m.put(v.getId(), v.getUsername()), (stringStringHashMap, m) -> {
            System.out.println("。。。。。。。");
            stringStringHashMap.putAll(m);
        });
        map.forEach((k,v)-> System.out.println(String.format("k：%s，v：%s",k,v)));

        Map<String, String> map2 = list.stream().parallel().collect(HashMap::new, (m, v) -> m.put(v.getId(), v.getUsername()), (stringStringHashMap, m) -> {
            System.out.println("。。。parallel。。。。");
            stringStringHashMap.putAll(m);
        });
        map2.forEach((k,v)-> System.out.println(String.format("k：%s，v：%s",k,v)));
    }


    @Test
    public void test6(){
        List<User> list = Lists.newArrayList(new User("1","张三"),new User("1","李四"),new User("3","王五"));
        //获取一个 Map，key 是用户的 id，value 是用户,id 相同，后面覆盖前面的
        Map<String, User> map = list.stream().collect(Collectors.toMap(User::getId, Function.identity(), (user, user2) -> user2));
        map.forEach((k,v)-> System.out.println(String.format("k：%s，v：%s",k,v)));
    }

    @Test
    public void test7(){
        //有两个用户的 id 是相同的
        List<User> list = Lists.newArrayList(new User("1","张三"),new User("1","李四"),new User("3","王五"));
        //获取一个 Map，key 是用户的 id，value 是用户
        Map<String, User> map = list.stream().collect(Collectors.toMap(User::getId, Function.identity()));
        map.forEach((k,v)-> System.out.println(String.format("k：%s，v：%s",k,v)));
    }

    @Test
    public void test8(){
        List<User> list = Lists.newArrayList(new User("1","张三"),new User("2","李四"),new User("3","王五"));
        //获取 id 大于 1 的 User
        List<User> collect = list.stream().filter(user -> Integer.valueOf(
                user.getId()
        ) > 1).collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void test9(){
        List<User> list = Lists.newArrayList(new User("1","张三"),new User("2","李四"),new User("3","王五"),new User("1","赵六"),new User("2","王七"));
        Map<String, List<User>> collect = list.stream().collect(Collectors.groupingBy(User::getId));
        System.out.println(collect);
    }
}
