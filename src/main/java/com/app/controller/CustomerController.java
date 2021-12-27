package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Customer;
import com.app.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	// display list of employees
	@GetMapping("/")
	public String viewHomePage(Model model) {
		
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "index";
	}
	
	@PostMapping("/checkUsers")
	public String checkUsers(@Valid Customer customer, BindingResult result, Model model) {
		// save employee to database
		
		System.out.println(customer.getCustomerCompany());
		System.out.println(customer.getUsernameOld());
		System.out.println(customer.getPasswordOld());
		
		if(customer.getCustomerCompany() != null & customer.getUsernameOld() != null && customer.getPasswordOld() != null) {
			
			Customer custExit = customerService.getByUsername(customer.getCustomerCompany()+customer.getUsernameOld());
			
			if(custExit == null) {
				System.out.println("data customer Null");
				
				model.addAttribute("statusError", true);
			}else {
				System.out.println("data customer ada");
				
				BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();  
				Boolean match = encoder.matches(customer.getPasswordOld(), custExit.getPasswordOld()); 
				System.out.println(match);
				
				if(match) {
					model.addAttribute("statusError", false);
					model.addAttribute("usernameBaru", custExit.getUsernameKey());
					model.addAttribute("passwordBaru", custExit.getPasswordNew());
				}else {
					model.addAttribute("statusError", true);
					
				}
				
			}
			
		}
		
		
		return "index";
	}
	
	/*
	@GetMapping("/")
	public String viewHomePage(Model model) {
		return findPaginated(1, "firstName", "asc", model);		
	}
	

	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		// create model attribute to bind form data
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "new_employee";
	}
	
	@PostMapping("/@{/checkUsers}")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		// save employee to database
		employeeService.saveEmployee(employee);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
		
		// get employee from the service
		Employee employee = employeeService.getEmployeeById(id);
		
		// set employee as a model attribute to pre-populate the form
		model.addAttribute("employee", employee);
		return "update_employee";
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable (value = "id") long id) {
		
		// call delete employee method 
		this.employeeService.deleteEmployeeById(id);
		return "redirect:/";
	}
	
	
	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 5;
		
		Page<Employee> page = employeeService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Employee> listEmployees = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		model.addAttribute("listEmployees", listEmployees);
		return "index";
	}*/
}
