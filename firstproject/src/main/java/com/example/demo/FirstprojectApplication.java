package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FirstprojectApplication 
{

	public static void main(String[] args)
	{
		
		ConfigurableApplicationContext context = SpringApplication.run(FirstprojectApplication.class, args);
		
		//System.out.println("Hello");
		
		//Alien a = new Alien(); Explicitly creating
		
		Alien a = context.getBean(Alien.class);
		a.show();
		
		//Alien a1 = context.getBean(Alien.class);
		//a1.show();
		//without scope prototype 
		//singleton pattern will be followed
		
	}	

}
