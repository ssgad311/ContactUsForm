package com.example.springboot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.springboot.model.Employee;
import com.example.springboot.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	// display list of employees
	@GetMapping("/")
	 public String ViewMainPage(){ 	 		
	 return "mainPage";
	}
	
	 @GetMapping("/contactUs")
	 public String ViewContactUsPage(Model model){ 	 
	model.addAttribute("listEmployees",employeeService.getAllEmployees());
	 return "index";
	
	 
	 
	
	 }
	 @GetMapping("/showNewEmployeeForm")
	 public String showNewEmployeeForm(Model model) {
		 //create model attribute to bind from data
		 Employee employee = new Employee();
		 model.addAttribute("employee", employee);
		 return "new_employee";
	 }
	 //@PostMapping("/saveEmployee")
	// public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		 //save employee to database
	//	 employeeService.saveEmployee(employee);
		//  return "redirect:/";
	 //}
	 
	 @PostMapping("/saveEmployee")
	 public String saveEmployee(Employee employee) {
	     // save employee to database
	     employeeService.saveEmployee(employee);
	     return "redirect:/";
	 }
	 
	 
	 @GetMapping("/showFormForUpdate/{custId}")
	 public String showFormForUpdate(@PathVariable (value = "custId")String custId, Model model) {
		 
		 // get employee from the service
		 Employee employee = employeeService.getEmployeeBycustId(custId);
		 
		 // set employee as a model attributes to pre-populate form
		 model.addAttribute("employee", employee);
		 return "update_employee";
	 }
	 
	@GetMapping("/deleteEmployee/{custId}") 
	public String deleteEmployee(@PathVariable (value = "custId") String custId) {
		//call the delete employee method 
		this.employeeService.deleteEmployeeBycustId(custId);
		   return "redirect:/"; 
	}
	 
}