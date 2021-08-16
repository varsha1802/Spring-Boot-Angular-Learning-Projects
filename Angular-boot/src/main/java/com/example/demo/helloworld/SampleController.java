package com.example.demo.helloworld;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.helloworld.HelloBean;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class SampleController {

	@GetMapping("/")
	String home()
	{
		return "Welcome";
	}
	
	@GetMapping("/hello")
	HelloBean hello()
	{
		//throw new RuntimeException("Some error has happened");
		return new HelloBean("hello world - changed");
	}
	
	@GetMapping("/hellopath/{name}")
	HelloBean hellopath(@PathVariable String name)
	{
		return new HelloBean(String.format("hello %s....! welcome", name));
	}
}
