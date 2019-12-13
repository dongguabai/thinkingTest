package demo.dongguabai.guava.grace.utils;

import com.google.common.base.Joiner;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.google.common.collect.ImmutableMap.of;

/**
 * @author dongguabai
 * @Description
 * @Date 创建于 2019-05-13 00:31
 */
public class JoinerTest {

    private static final List<String> list1 = Arrays.asList("a","b","c","d","e");
    private static final List<String> list2 = Arrays.asList("a","b","c","d",null);

    @Test
    public void test(){
        //集合使用 # 进行分割（这个集合没有 null）
        String s = Joiner.on("#").join(list1);
        System.out.println(s);  //a#b#c#d#e
    }

    @Test
    public void test2(){
        //集合使用 # 进行分割  如果集合中有为null的元素，上面的就会出现NPE
       //这样跳过空值
        String s = Joiner.on("#").skipNulls().join(list2);
        System.out.println(s);
    }

    @Test
    public void test3(){
        //集合使用 # 进行分割,如果有null就设置一个默认值
        String aDefault = Joiner.on("#").useForNull("default").join(list2);
        System.out.println(aDefault);  //a#b#c#d#default
    }

    /**
     * 直接返回一个StringBuilder
     */
    @Test
    public void test4(){
        StringBuilder sb = new StringBuilder();
        //集合使用 # 进行分割,如果有null就设置一个默认值,直接返回一个StringBuilder
        StringBuilder sb2 = Joiner.on("#").useForNull("default").appendTo(sb,list2);
        //要注意的是这里的 sb 和 sb2 其实就是同一个 实例

        //所以一般我们可以这么用
        StringBuilder sb3 = Joiner.on("#").useForNull("default").appendTo(new StringBuilder(), list2);

    }

    /**
     * 测试写到一个文件中去
     */
    @Test
    public void test5(){
        try (FileWriter writer = new FileWriter(new File("/Users/dongguabai/Desktop/测试文件.txt"))) {

            Joiner.on("#").useForNull("default").appendTo(writer, list2);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 实现自己的Joiner，有 null 元素就跳过
     */
    @Test
    public void test6(){
        String s = list2.stream().filter(item -> item != null && !item.isEmpty()).collect(Collectors.joining("#"));
        System.out.println(s);
    }

    /**
     * 实现自己的Joner,有null就给个默认值
     */
    @Test
    public void test7(){
        String s = list2.stream().map(item->item==null || item.isEmpty()?"DEFAULT":item).collect(Collectors.joining("#"));
        System.out.println(s);
    }

                                    //  导入方式更为陈述式
    private static final Map<String,String> map = of("姓名"," 张三","年龄","20","地址","湖北");


    /**
     * 处理map
     */
    @Test
    public void test8(){
        String join = Joiner.on("#").withKeyValueSeparator("：").join(map);
        System.out.println(join); //姓名： 张三#年龄：20#地址：湖北
    }


    private static final Map<String,String> map2 = of("姓名"," 张三","年龄","20","地址","湖北","电话",null);

    /**
     * 处理map，如果有null
     */
    @Test
    public void test9(){
        Map<String,String> mm = new HashMap<>();
        mm.put("a",null);
        map.put("b","c");
        //map中有null直接就报错了
        String join = Joiner.on("#").withKeyValueSeparator("：").useForNull("DEFAULT").join(mm);
        System.out.println(join); //姓名： 张三#年龄：20#地址：湖北
    }
}
