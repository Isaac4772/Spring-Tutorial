package com.aungpaing.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aungpaing.model.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
