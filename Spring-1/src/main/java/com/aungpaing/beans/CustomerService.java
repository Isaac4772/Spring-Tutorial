package com.aungpaing.beans;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	public Customer findById(int id) {
		if (id <= 0)
			return null;
		else {
			var customer = new Customer();
			customer.setId(id);
			customer.setName("John");
			return customer;
		}

	}
}
