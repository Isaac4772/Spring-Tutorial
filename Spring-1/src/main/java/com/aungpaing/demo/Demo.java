package com.aungpaing.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aungpaing.beans.University;

public class Demo {
	public static void main(String[] args) {
		ApplicationContext cxt = new AnnotationConfigApplicationContext();

		var university = cxt.getBean("universityBean", University.class);
	}
}
