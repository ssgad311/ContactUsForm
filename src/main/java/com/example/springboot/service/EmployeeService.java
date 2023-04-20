package com.example.springboot.service;

import java.util.List;

import com.example.springboot.model.Employee;

public interface EmployeeService {
        List<Employee> getAllEmployees();
        
        void saveEmployee(Employee employee);
        Employee getEmployeeBycustId(String custId);
        void deleteEmployeeBycustId(String custId);
	
}
