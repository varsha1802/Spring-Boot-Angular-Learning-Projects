package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.elasticsearch.search.aggregations.Aggregations;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;


@RestController
public class QueryDslController {

	@Autowired
	private CustomerService customerServ;
	
	@Autowired
	private CustomerRepository repository;
	
	@PostMapping("/save-customer")
	public int saveCustomer(@RequestBody List<Customer> customers){
		repository.saveAll(customers);
		return customers.size();
	}
		
	@PutMapping("/update-customer")
 	public Customer updCustomer(@RequestBody Customer customer)
	{
		repository.save(customer);
		return customer;
	}
	
	@DeleteMapping("/delete-customer/{id}") 
	public String deleteCustomer(@PathVariable String id)
	{
		Customer customer = repository.findById(id).orElse(null);
		repository.delete(customer);
		return "Successfully Deleted.....!";
	}	
	
	@GetMapping(value="/findAll")
	public List<Customer> findAllCustomers(){
		//return repository.findAll();
		return customerServ.findAllCustomerDetailsFromElastic(); 
	}
	
	@GetMapping(value="/findby-name/{firstName}")
	public List<Customer> getCustomerDataByName(@PathVariable String firstName){
		return customerServ.findAllCustomerDataFromElastic(firstName); 
	}
	
	@GetMapping(value="/findby-name/{firstName}/{age}")
	public List<Customer> getCustomerDataByNameAndAge(@PathVariable String firstName, @PathVariable int age){
		return customerServ.findAllCustomerDataByNameAndAge(firstName,age); 
	}	
	
	@GetMapping(value="/findby-aggs")
	public ArrayList<HashMap> getCustomerDataByAgg(){
		return customerServ.findAllCustomerDataByAggs(); 
	}	
	
	
}
