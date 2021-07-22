package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
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