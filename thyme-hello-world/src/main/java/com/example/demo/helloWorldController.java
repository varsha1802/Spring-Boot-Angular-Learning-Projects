package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.ArrayList;
import java.util.List;

@Controller
public class helloWorldController 
{
	@GetMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("message","Hello world");
		return "helloWorld";
	}
	
	@GetMapping("/style")
	public String style(Model model) {
		
		return "addCssJs";
	}
	
	@GetMapping("/boot")
	public String boot(Model model) {
		
		return "addBootstrap";
	}
	
	@GetMapping("/if-unless")
	public String users(Model model) {
		List<User> users = new ArrayList<>();
		users.add(new User("xxx","xxx@gmail.com","admin"));
		users.add(new User("yyy","yy@gmail.com","user"));
		users.add(new User("zzz","zzz@gmail.com","user"));
		model.addAttribute("users",users);
		return "ifUnless";
	}
	
	@GetMapping("/switch-case")
	public String switchCase(Model model) {
		User user = new User("xxx","xxx@gmail.com","admin");
		model.addAttribute(user);
		return "switch";
	}
}