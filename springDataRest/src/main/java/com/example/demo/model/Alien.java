package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Alien 
{
	@Id
	@GeneratedValue
	private int aid;
	
	private String aname;
	
	private String tech;
	
	private String zname;
	
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
	
	public String getZname() {
		return zname;
	}

	public void setZname(String zname) {
		this.zname = zname;
	}

	@Override
	public String toString() {
		return "Alien [aid=" + aid + ", aname=" + aname + ", tech=" + tech + ", City=" + zname + "]";
	}
	
}
