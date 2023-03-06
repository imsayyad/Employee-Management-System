package com.springboot.ems.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.ems.Entity.Employee;
import com.springboot.ems.exception.DataSourceNotFoundException;
import com.springboot.ems.repository.EmployeeRepository;
import com.springboot.ems.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(long id) {
//		Optional<Employee> employee = employeeRepository.findById(id);
//		if (employee.isPresent()) {
//			return employee.get();
//		} else {
//			throw new DataSourceNotFoundException("Employee", "id", id);
//		}
		//alternate way using Lambda expression
		return employeeRepository.findById(id).orElseThrow(() -> 
					new DataSourceNotFoundException("Employee", "id", id));
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> 
					new DataSourceNotFoundException("Employee", "Id", id));
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		
		//statement for saving updated details
		employeeRepository.save(existingEmployee);
		return existingEmployee;
	}

	@Override
	public void deleteEmployee(long id) {
		employeeRepository.findById(id).orElseThrow(() -> 
		new DataSourceNotFoundException("Employee", "Id", id));
		
		employeeRepository.deleteById(id);
	}

	 

}
