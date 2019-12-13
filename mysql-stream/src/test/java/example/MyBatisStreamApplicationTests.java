package example;

import com.example.MyBatisStreamApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author dongguabai
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyBatisStreamApplication.class)
public class MyBatisStreamApplicationTests {

	@Test
	public void test1(){
		System.out.println("1111");
	}

}