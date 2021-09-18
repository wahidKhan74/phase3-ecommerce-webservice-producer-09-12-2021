package com.simplilearn.webservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.webservice.entity.User;
import com.simplilearn.webservice.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	UserRepository userRepo;
	
	@PostMapping("/register")
	public User addProduct(@RequestBody User userObj){
		User user = userRepo.save(userObj);
		return user;
	}
}
