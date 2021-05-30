package com.parwej.employeeManager.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parwej.employeeManager.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {

	void deleteEmployeeById(Long id);

	Optional<Employee> findEmployeeById(Long id);
	
	
	
}
