package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import com.example.demo.model.Person;
import com.example.demo.repositories.PersonRepo;

@Controller
public class PersonController 
{
	
	@Autowired
	public PersonRepo personRepo;
	
	@GetMapping(value = "/persons")
	@ResponseBody
	public List<Person> getAllPersons()
	{		
		return personRepo.findAll();	
		
	}
	
	@PostMapping(value = "/person")
	@ResponseBody
	public String createPerson(@RequestBody Person person) {
		
		Person insertedPerson = personRepo.insert(person);
		return "Student Created........! Name --> " + insertedPerson.getName();
	}
	
	@GetMapping("/person/{pid}")
	@ResponseBody
	public Person fetchPerson(@PathVariable("pid") int pid)
	{
		return personRepo.findById(pid).orElse(null);
	}
	
	@DeleteMapping("/person/{id}") 
	@ResponseBody
	public String deletePerson(@PathVariable int id)
	{
		Person person = personRepo.findById(id).orElse(null);
		personRepo.delete(person);
		return "Successfully Deleted.....!";
	}
	
	@PutMapping("/person") 
	@ResponseBody
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
 	@ResponseBody
	public Person updPerson(@RequestBody Person person)
	{
		personRepo.save(person);
		return person;
	}
	*/
	
	@GetMapping("/persons/page/{pageNo}/{sortField}/{sortDir}")
	@ResponseBody
	public List<Person> findPaginated(@PathVariable("pageNo") int pageNo,
			@PathVariable("sortField") String sortField,
			@PathVariable("sortDir") String sortDir
			)
	{
		int pageSize = 3;
		Sort sort = sortDir.equals("asc") ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		Page<Person> page = personRepo.findAll(pageable);		
		return page.getContent();
	}
	
	@GetMapping("/person-place/{place}")
	@ResponseBody
	public List<Person> findByname(@PathVariable String place)
	{
		List<Person> namelist = personRepo.findByPlace(place);
		return namelist;
	}
	
	@GetMapping("/person-greater/{age}")
	@ResponseBody
	public List<Person> findByGreater(@PathVariable int age)
	{		
		List<Person> greaterlist = personRepo.findByAgeGreaterThan(age);
		return greaterlist;
	}
	
	@GetMapping("/person-between/{age1}/{age2}")
	@ResponseBody
	public List<Person> findByageCriteria(@PathVariable int age1, @PathVariable int age2)
	{		
		List<Person> resultlist = personRepo.findPersonsByAgeBetween(age1, age2);
		return resultlist;
	}
	
	@GetMapping("/person-custom/{start}")
	@ResponseBody
	public List<Person> findByGreater(@PathVariable String start)
	{		
		List<Person> customPersons = personRepo.findByNameLikeOrderByAgeAsc(start);
		return customPersons;
	}
	
	@RequestMapping("/")
	public String home()
	{
		return "home.jsp";
	}
	
	@RequestMapping("/login")
	public String login()
	{
		return "login.jsp";
	}
	
	@RequestMapping("/logout-success")
	public String logout()
	{
		return "logout.jsp";
	}
	

}
