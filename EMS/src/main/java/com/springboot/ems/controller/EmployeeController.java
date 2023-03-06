package com.springboot.ems.controller;

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

import com.springboot.ems.Entity.Employee;
import com.springboot.ems.service.EmployeeService;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	//API for requesting all employee data
	@GetMapping("getEmployees")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}
	
	//API for record creation
	@PostMapping("save")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
	}
	
	//API for getting single record 
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id) {
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(id), HttpStatus.OK);
	}
	
	//API for updating employee details
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id,
														@RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.CREATED);
	}
	
	//API for deleting record of employee
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id) {
		employeeService.deleteEmployee(id);
		return new ResponseEntity<String>("Employee record deleted successfully!!!",HttpStatus.OK);
	}
}
