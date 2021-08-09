package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.elasticsearch.search.aggregations.Aggregations;
import org.json.JSONArray;
import org.json.JSONObject;

import com.example.demo.model.Customer;


public interface CustomerService 
{		
	public List<Customer> findAllCustomerDetailsFromElastic();		
	public List<Customer> findAllCustomerDataFromElastic(String firstName);
	public List<Customer> findAllCustomerDataByNameAndAge(String firstName, int age);
	public ArrayList<HashMap> findAllCustomerDataByAggs();	
}
