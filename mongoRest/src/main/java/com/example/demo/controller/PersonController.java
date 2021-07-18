package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Person;
import com.example.demo.repositories.PersonRepo;

@RestController
public class PersonController 
{
	
	@Autowired
	public PersonRepo personRepo;
	
	@GetMapping(value = "/persons")
	public List<Person> getAllPersons()
	{
		return personRepo.findAll();		
	}
	
	@PostMapping(value = "/person")
	public String createPerson(@RequestBody Person person) {
		
		Person insertedPerson = personRepo.insert(person);
		return "Student Created........! Name --> " + insertedPerson.getName();
	}
	
	@GetMapping("/person/{pid}")
	public Person fetchPerson(@PathVariable("pid") int pid)
	{
		return personRepo.findById(pid).orElse(null);
	}
	
	@DeleteMapping("/person/{id}") 
	public String deletePerson(@PathVariable int id)
	{
		Person person = personRepo.findById(id).orElse(null);
		personRepo.delete(person);
		return "Successfully Deleted.....!";
	}
	
	@PutMapping("/person") 
	public Person updPerson(@RequestBody Person person)
	{
		int id = (int)person.getId();
		Person updatePerson = personRepo.findById(id).orElse(new Person()); 
		updatePerson.setId(person.getId());
		updatePerson.setName(person.getName());
		updatePerson.setAge(person.getAge());
		updatePerson.setPlace(person.getPlace());
		personRepo.save(updatePerson);
		return updatePerson;
	}
	
	/*
	@PutMapping("/person") 
	public Person updPerson(@RequestBody Person person)
	{
		personRepo.save(person);
		return person;
	}
	*/	

}
