package com.example.demo;


import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController
{
	
	/*
	@RequestMapping("sample") //this alone --> downloads home.html
	//@ResponseBody --> Returns as string
	//@GetMapping(path="/home")
	public String sample()
	{		
		System.out.println("Hey its running......!");
		return "sample.html";
	}
	*/
	
	/*
	@RequestMapping("home")
	public String home(HttpServletRequest req)
	{
		HttpSession session = req.getSession();
		String name = req.getParameter("name");
		System.out.println("hi "+name);
		session.setAttribute("name", name);
		return "home";
	}
	*/
	
	/*
	@RequestMapping("home")
		public String home(@RequestParam("name") String myName, HttpSession session)
	{
		System.out.println("hi "+myName);
		session.setAttribute("name", myName);
		return "home";
	}
	*/
	
	/*
	@RequestMapping("home")
	public ModelAndView home(@RequestParam("name") String myName)
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("name",myName);
		mv.setViewName("home");
		System.out.println("Success --> "+myName);
		return mv;
	}
	*/
	
	@RequestMapping("home")
	public ModelAndView home(Alien alien)
	{
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("obj",alien);
		System.out.println("<--Success-->");
		return mv;
	}


}
