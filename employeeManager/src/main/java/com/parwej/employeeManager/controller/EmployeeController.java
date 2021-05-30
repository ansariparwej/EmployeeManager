package com.parwej.employeeManager.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parwej.employeeManager.model.Employee;
import com.parwej.employeeManager.service.EmployeeService;

@RestController
@RequestMapping("/employee/v1")
public class EmployeeController {

	private final EmployeeService es;

	public EmployeeController(EmployeeService es) {
		// TODO Auto-generated constructor stub
		this.es = es;
	}

	// get all employee
	@GetMapping("/getAll")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		List<Employee> l = es.findAllEmployees();
		return new ResponseEntity<>(l, HttpStatus.OK);
	}

	// create
	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee e) {
		return new ResponseEntity<>(es.addEmployee(e), HttpStatus.CREATED);
	}

	// read
	@GetMapping("/get/{id}")
	public ResponseEntity<Employee> getEmplyee(@PathVariable("id") Long id) {
		return new ResponseEntity<>(es.findEmployeeById(id), HttpStatus.OK);
	}

	// update
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee e) {
		return new ResponseEntity<>(es.updateEmployee(e), HttpStatus.OK);
	}

	// delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEmplyee(@PathVariable("id") Long id) {
		es.deleteEmployee(id);
		return new ResponseEntity<>("Success",HttpStatus.OK);
	}

}
