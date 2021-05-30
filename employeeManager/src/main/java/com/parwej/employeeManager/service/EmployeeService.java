package com.parwej.employeeManager.service;

import java.util.List;
import java.util.UUID;

import javax.persistence.MappedSuperclass;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.parwej.employeeManager.exception.UserNotFoundException;
import com.parwej.employeeManager.model.Employee;
import com.parwej.employeeManager.repo.EmployeeRepo;

@Service
public class EmployeeService {

	private final EmployeeRepo employeeRepo;

	@Autowired
	public EmployeeService(EmployeeRepo employeeRepo) {
		this.employeeRepo = employeeRepo;
	}

	// add new employee
	public Employee addEmployee(Employee employee) {
		employee.setEmployeeCode(UUID.randomUUID().toString());
		return employeeRepo.save(employee);
	}

	// get all employee
	public List<Employee> findAllEmployees() {
		return employeeRepo.findAll();
	}

	// update employee
	public Employee updateEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}

	// delete employee
	public void deleteEmployee(Long id) {
		employeeRepo.deleteById(id);
	}

	// get Employee by id
	public Employee findEmployeeById(Long id) {
		return employeeRepo.findEmployeeById(id)
				.orElseThrow(() -> new UserNotFoundException("User by id " + id + "not found"));
	}

}
