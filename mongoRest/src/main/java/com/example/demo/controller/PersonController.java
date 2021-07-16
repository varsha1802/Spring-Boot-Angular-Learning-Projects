package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Person;
import com.example.demo.repositories.PersonRepo;

@RestController
public class PersonController 
{
	
	@Autowired
	public PersonRepo personRepo;
	
	@GetMapping(value = "/all")
	public List<Person> getAllPersons()
	{
		return personRepo.findAll();		
	}
	
	@PostMapping(value = "/create")
	public String createPerson(@RequestBody Person person) {
		
		Person insertedPerson = personRepo.insert(person);
		return "Student Created........!" + insertedPerson.getName();
	}
	

}
