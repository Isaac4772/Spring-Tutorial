package com.aungpaing.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class Customer {

	private int id;
	private String name;

	public Customer() {

	}

	public Customer(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@PostConstruct
	public void start() {
		System.out.println("Thi is init method");
	}

	@PreDestroy
	public void end() {
		System.out.println("This is destroy method");
	}

	public void save() {
		System.out.println("This is utility method");
	}
}
