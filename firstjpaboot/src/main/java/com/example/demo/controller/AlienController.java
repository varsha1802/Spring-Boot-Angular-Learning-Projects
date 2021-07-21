package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;

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

import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.AlienRepo;

import com.example.demo.model.Alien;

import java.util.List;

import java.util.Optional;

@Controller
public class AlienController 
{
	
	@Autowired
	AlienRepo repo;
	
	@RequestMapping("/")
	public String home()
	{
		return "home.jsp";
	}
	
	@RequestMapping("/addAlien")
	public String addAlien(Alien alien)
	{
		repo.save(alien);
		return "home.jsp";
	}
	
	@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam int aid)
	{
		ModelAndView mv = new ModelAndView("showAlien.jsp");
		Alien alien = repo.findById(aid).orElse(null);
		mv.addObject(alien);
		return mv;
	}
	
	@RequestMapping("/delAlien")
	public String addAlien(@RequestParam int aid)
	{
		Alien alien = repo.findById(aid).orElse(null);
		repo.delete(alien);
		return "home.jsp";
	}
	
	@RequestMapping("/updateAlien")
	public String updateAlien(Alien alien)
	{
		repo.save(alien);
		return "home.jsp";
	}
	
	@RequestMapping("/findByTechAlien")
	public ModelAndView findByTechAlien(@RequestParam String tech)
	{
		ModelAndView mv = new ModelAndView("showAlien.jsp");
		List<Alien> techlist = repo.findByTech(tech);
		mv.addObject("alien",techlist);
		return mv;
	}
	
	@RequestMapping("/findByGreater")
	public ModelAndView findByGreater(@RequestParam int aid)
	{
		ModelAndView mv = new ModelAndView("showAlien.jsp");
		List<Alien> greaterlist = repo.findByAidGreaterThan(aid);
		mv.addObject("alien",greaterlist);
		return mv;
	}
	
	@RequestMapping("/findByTechSorted")
	public ModelAndView findByTechSorted(@RequestParam String tech, @RequestParam String zname)
	{
		ModelAndView mv = new ModelAndView("showAlien.jsp");
		List<Alien> sortlist = repo.findByTechSorted(tech,zname);
		mv.addObject("alien",sortlist);
		return mv;
	}
	
	/*Returns Array of Objects
	@RequestMapping("/aliens")
	@ResponseBody
	public String getAliens()
	{
		return repo.findAll().toString();
	}
	
	@RequestMapping("/alien/{aid}")
	@ResponseBody
	public String fetchAlien(@PathVariable("aid") int aid)
	{
		return repo.findById(aid).toString();
	}
	*/
	
		
	@GetMapping("/aliens")
	@ResponseBody
	public List<Alien> getAliens()
	{
		return repo.findAll();
	}
	
	
	/*
	@GetMapping(path="/aliens",produces= {"application/xml"})
	@ResponseBody
	public List<Alien> getAliens()
	{
		return repo.findAll();
	}
	*/
	
	@GetMapping("/alien/{aid}")
	@ResponseBody
	public Optional<Alien> fetchAlien(@PathVariable("aid") int aid)
	{
		return repo.findById(aid);
	}
	
	@PostMapping("/alien") //"consumes" attribute ==> specifies what type of data to accept
	@ResponseBody
	public Alien addingAlien(@RequestBody Alien alien)
	{
		repo.save(alien);
		return alien;
	}
	
	@DeleteMapping("/alien/{aid}") 
	@ResponseBody
	public String deleteAlien(@PathVariable int aid)
	{
		Alien alien = repo.findById(aid).orElse(null);
		repo.delete(alien);
		return "Deleted.....!";
	}
	
	@PutMapping("/alien") 
	@ResponseBody
	public Alien updAlien(@RequestBody Alien alien)
	{
		repo.save(alien);
		return alien;
	}
	
}
