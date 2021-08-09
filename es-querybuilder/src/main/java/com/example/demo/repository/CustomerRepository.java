package com.example.demo.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Customer;

@Repository
public interface CustomerRepository extends ElasticsearchRepository<Customer, String>
{

	

	//List<Customer> findByFirstname(String firstName);	
	
}


