package com.siddharth.mvccruddemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.siddharth.mvccruddemo.entity.Employee;
import com.siddharth.mvccruddemo.service.EmployeeService;


//this testing the devlopment branch
@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
//	public EmployeeController(EmployeeService theEmployeeService) {
//		 employeeService= theEmployeeService;
//	
//	
//	}
	//add mapping for "/List"
	
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		//get the employee form database
		
		List<Employee> theEmployees=employeeService.findAll();
		
		
		//add to the spring model
		theModel.addAttribute("employees", theEmployees);
		
		return "employees/list-employee";
	}

	@GetMapping("/showFormForAdd")
	 public String showFromForAdd(Model theModel) {
		//create model attribute to bind form data 
		
		Employee theEmployee=new Employee();
		theModel.addAttribute("employee" ,theEmployee);
		return "employees/employee-form";
	}
	
	@GetMapping("/showFromForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId,Model theModel) {
		//get the employee form the service
		Employee theEmployee=employeeService.findById(theId);
		
		
		//set employee in the model to prepopulate the form
		theModel.addAttribute("employee",theEmployee);
		
		
		//send over to our form
		return "employees/employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
	
		//save the employee
		employeeService.save(theEmployee);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/employees/list";
	}
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int theId) {
		//delete an employee
		employeeService.deleteById(theId);
		
		//redirect to the /employees/list
		return "redirect:/employees/list";
	}
	
	
}
