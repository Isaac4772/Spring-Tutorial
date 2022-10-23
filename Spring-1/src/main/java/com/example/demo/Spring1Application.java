package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aungpaing.beans.University;
import com.mmit.config.Config2;

@SpringBootApplication
public class Spring1Application {

	public static void main(String[] args) {
//		SpringApplication.run(Spring1Application.class, args);
		ApplicationContext cxt = new AnnotationConfigApplicationContext(Config2.class);

		University uni = cxt.getBean(University.class);

		uni.show();
	}

}
