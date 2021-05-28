package com.parwej.employeeManager.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parwej.employeeManager.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {
	
	
	
}
