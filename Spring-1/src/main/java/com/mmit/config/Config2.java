package com.mmit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aungpaing.beans.Customer;
import com.aungpaing.beans.CustomerService;
import com.aungpaing.beans.Person;
import com.aungpaing.beans.Teacher;
import com.aungpaing.beans.University;

@Configuration
public class Config2 {

	@Bean
	public Customer customerBean() {
		return new Customer();
	}

	@Bean
	public CustomerService customerServiceBean() {
		return new CustomerService();
	}

//	@Bean
//	public Teacher teacherBean() {
//		return new Teacher();
//	}
//
//	@Bean
//	public University universyBean() { // DI with Constructor
//		var uni = new University(teacherBean());
//		return uni;
//	}
//
//	@Bean
//	public University university() { // DI with setter
//		var uni = new University(null);
//		uni.setTeacher(teacherBean());
//		return uni;
//	}
//
//	@Bean
//	public Person personBean() {
//		var person = new Person();
//		person.setName("Aung");
//		return person;
//	}
}
