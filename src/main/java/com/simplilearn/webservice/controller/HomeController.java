package com.simplilearn.webservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/")
	public String indexMapping() {
		return "Server is up & running on port 8000";
	}
	
	@GetMapping("/hello")
	public String helloMapping() {
		return "Hello, everyone ! welcome to webservice learning !";
	}
	
	// request parameter
	@GetMapping("/hi")
	public String hiMapping(@RequestParam(value ="name") String name) {
		return "Hi, '"+name+"' welcome to webservice learning !";
	}
	
	@GetMapping("/user")
	public String userMapping() {
		return "<h1> Welcome Spring security - USER </h1>";
	}
	
	
	@GetMapping("/admin")
	public String adminMapping() {
		return "<h1> Welcome Spring security - ADMIN </h1>";
	}
	
}
