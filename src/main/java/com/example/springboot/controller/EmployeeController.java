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
	public String viewMainPage() {
		return "index";
	}

	
	@GetMapping("/listAllEmployees")
	public String getAllEmployees(Model model) {
		model.addAttribute("listEmployees", employeeService.getAllEmployees());
		return "employees";

	}
	
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		// create model attribute to bind from data
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "new_employee";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(Employee employee,Model model) {
		// save employee to database
		employeeService.saveEmployee(employee);
		model.addAttribute("message", "registered successfully for contact us !!!");
		return "new_employee";
	}
	
	@GetMapping("/showFormForUpdate/{custId}")
	public String showFormForUpdate(@PathVariable(value = "custId") int custId, Model model) {

		// get employee from the service
		Employee employee = employeeService.getEmployeeBycustId(custId);

		// set employee as a model attributes to pre-populate form
		model.addAttribute("employee", employee);
		return "update_employee";
	}
	
	@GetMapping("/deleteEmployee/{custId}")
	public String deleteEmployee(@PathVariable(value = "custId") int custId) {
		// call the delete employee method
		this.employeeService.deleteEmployeeBycustId(custId);
		return "redirect:/listAllEmployees";
	}
	
	

	

	
	// @PostMapping("/saveEmployee")
	// public String saveEmployee(@ModelAttribute("employee") Employee employee) {
	// save employee to database
	// employeeService.saveEmployee(employee);
	// return "redirect:/";
	// }

	

	

	

}