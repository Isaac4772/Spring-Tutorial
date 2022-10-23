package com.aungpaing.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aungpaing.beans.Customer;
import com.aungpaing.beans.CustomerRepo;
import com.aungpaing.beans.CustomerService;
import com.mmit.config.Config2;

public class Demo3 {

	public static void main(String[] args) {

		var cxt = new AnnotationConfigApplicationContext(Config2.class);

//		var customerService = cxt.getBean(CustomerService.class);
//
//		var customer = customerService.findById(0);
//
//		System.out.println(customer);

		var custRepo = cxt.getBean(CustomerRepo.class);
		custRepo.save(new Customer(1111, "Isaac"));
	}

}
