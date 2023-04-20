package com.example.springboot.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.model.Employee;
import com.example.springboot.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}


	@Override
	public void saveEmployee(Employee employee) {
		this.employeeRepository.save(employee);	
		
	}


	@Override
	public Employee getEmployeeBycustId(String custId) {
		Optional<Employee> optional = employeeRepository.findById(custId);
		Employee employee = null;
		if(optional.isPresent()) {
			employee = optional.get();
			}else {
				throw new RuntimeException("Employee not found for id ::" + custId);
			}
		return employee;
	}


	@Override
	public void deleteEmployeeBycustId(String custId) {
		this.employeeRepository.deleteById(custId);
		
	}

}
