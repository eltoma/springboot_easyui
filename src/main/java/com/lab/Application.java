package com.lab;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lab.mapper") // 注册mapper类的bean
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
