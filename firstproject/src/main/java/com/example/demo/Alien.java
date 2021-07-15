package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype")
//scope prototype will creates the object
//only when you request for the bean
public class Alien {
	
	private int aid;
	private String aname;
	private String tech;
	@Autowired //searches by type
	@Qualifier("lap") //searches by name
	private Laptop laptop;
	
	public Alien() {
		super();
		System.out.println("Object Created for class Alien");
		//Even if we failed to access this in main
		//this object will be created
		//Spring provides all the objects pre-handedly
		//once the application gets started.
	}
	
	public int getAid() {
		return aid;
	}
	
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getTech() {
		return tech;
	}
	public void setTech(String tech) {
		this.tech = tech;
	}
	public Laptop getLaptop() {
		return laptop;
	}

	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}

	public void show() {
		System.out.println("Function show");
		laptop.compile();
	}
	

}
