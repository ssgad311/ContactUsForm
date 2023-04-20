package com.example.springboot.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

public class ContactForm {

	
	@GetMapping("/contactUs")
	public String showContactUsForm(Model model) {
	    // Add your logic here for handling the GET request for the contact us form
	    // You can use the Model object to pass data to the view
	    
	    // Return the view name for the contact us form
	    return "contact_us";
	}

	@PostMapping("/contactUs")
	public String submitContactUsForm(@ModelAttribute("contactForm") ContactForm contactForm) {
	    // Add your logic here for handling the POST request for the contact us form
	    // You can access the form data from the ContactForm object passed as a parameter
	    // You can use the contactForm object to access the form fields (e.g., contactForm.getName(), contactForm.getEmail(), etc.)
	    
	    // Return the view name for the contact us success page
	    return "contact_us_success";
	}

}
//	@GetMapping("/showNewEmployeeForm")
//	public String showContactUsForm(Model model) {
//	    // Create model attribute to bind contact us data
//	    ContactUsForm contactUsForm = new ContactUsForm();
//	    model.addAttribute("contactUsForm", contactUsForm);
//	    return "contact_us";
//	}
//
//	
//	
//	
//}
