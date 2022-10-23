package com.aungpaing.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aungpaing.beans.Customer;
import com.aungpaing.beans.Person;

public class DemoApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		var cxt = new AnnotationConfigApplicationContext("Config2");
//
//		var customer = cxt.getBean(Customer.class);
//		customer.save();

		var person1 = cxt.getBean(Person.class);
		person1.setName("Jeon");

		var person2 = cxt.getBean(Person.class);
		person2.getName();

		System.out.println("Person 1 : " + person1.getName());
		System.out.println("Person 2 : " + person2.getName());

		person2.setName("Marata");

		System.out.println("Person 1 : " + person1.getName());
		System.out.println("Person 2 : " + person2.getName());
		cxt.close();
	}

}
