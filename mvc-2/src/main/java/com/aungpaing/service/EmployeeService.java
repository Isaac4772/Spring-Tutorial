package com.aungpaing.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aungpaing.model.entities.Employee;
import com.aungpaing.model.repo.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repo;

	public void save(Employee employee) {

		repo.save(employee);

	}

	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public Object findById(int id) {
		return repo.findById(id);
	}

	public void deleteById(int empId) {
		repo.deleteById(empId);
	}
}
