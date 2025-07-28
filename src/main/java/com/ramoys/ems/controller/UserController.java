package com.ramoys.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ramoys.ems.model.Users;
import com.ramoys.ems.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/register")
	public Users registerUser(@RequestBody Users user) {
		return userService.registerUser(user);
	}
	@PostMapping("/login")
	public String loginUser(@RequestBody Users user) {
		return userService.verifyUser(user);
	}
}
