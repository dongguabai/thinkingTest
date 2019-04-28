package dongguabai.demo.java8.lambda.why;

import org.testng.annotations.Test;

import java.util.Optional;

/**
 * @author dongguabai
 * @Description
 * @Date 创建于 2019-04-26 16:20
 */
public class Test1 {

    /**
     * File
     */
    @Test
    public void test1(){
        Optional<Object> empty = Optional.empty();
        System.out.println(empty.toString());
    }
}
