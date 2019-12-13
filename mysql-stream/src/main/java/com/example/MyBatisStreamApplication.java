package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author dongguabai
 */
@SpringBootApplication
//@MapperScan("com.example.synchronizedTransactional.dao")
public class MyBatisStreamApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyBatisStreamApplication.class, args);
	}

}