package com.springboot.ems.service;

import java.util.List;

import com.springboot.ems.Entity.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployees();
	Employee saveEmployee(Employee employee);
	Employee getEmployeeById(long id);
	Employee updateEmployee(Employee employee,long id);
	void deleteEmployee(long id); 
}
