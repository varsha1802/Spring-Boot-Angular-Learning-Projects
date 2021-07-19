package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@Controller
public class EmployeeController
{	
	@Autowired
	private EmployeeService employeeService;
	
	//Initial home page displaying list of employees
	@GetMapping("/")
	public String viewHomePage(Model model) 
	{		
		/*
		 model.addAttribute("listEmployees",employeeService.getAllEmployees());
		 return "index";
		 */
		return findPaginated(1,"id", "asc",  model);
	}
	
	//form to add new employee
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm()
	{
		return "newEmployee";
	}
	
	//Saves new employee when submit button clicked in new employee form
	@PostMapping("/saveEmployee")
	public String saveEmployee(Employee employee) {
		
		employeeService.saveEmployee(employee);
		return "redirect:/";
	}
	
	//form to update an existing employee
	@GetMapping("/showFormUpdate/{id}")
	public String showFormUpdate(@PathVariable(value = "id") long id, Model model)
	{
		Employee employee = employeeService.getEmployeeById(id);
		model.addAttribute("employee",employee);
		return "updateEmployee";
	}
	
	//Deletes an employee from DB
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable("id") long id) {
		employeeService.deleteEmployeeById(id);
		return "redirect:/";
	}
	
	//form to display employees having ID greater than the given ID
	@GetMapping("/showDispEmployeeForm")
	public String showDispEmployeeForm()
	{
		return "showDispEmployee";
	}
	
	//Displays employee details having ID greater than the given ID
	@GetMapping("/displayEmployee")
	public String displayEmployee(@RequestParam long id, Model model)
	{
		model.addAttribute("listEmployees",employeeService.findByIdGreater(id));
		return "displayEmployee";
		
	}
	
	
	
	//Implements paging and sorting
	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable("pageNo") int pageNo,
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model)
	{
		int pageSize = 3;
		Page<Employee> page = employeeService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Employee> listEmployees = page.getContent();
		
		model.addAttribute("listEmployees",listEmployees); 
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages",page.getTotalPages()); 
		model.addAttribute("totalItems",page.getTotalElements());
		
		model.addAttribute("sortField",sortField);
		model.addAttribute("sortDirection",sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
				
		return "index";
	}
	
}
