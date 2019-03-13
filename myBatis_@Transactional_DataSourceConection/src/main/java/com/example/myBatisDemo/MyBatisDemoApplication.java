package com.example.myBatisDemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.MyBatisDemo.dao")
public class MyBatisDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyBatisDemoApplication.class, args);
	}

}
