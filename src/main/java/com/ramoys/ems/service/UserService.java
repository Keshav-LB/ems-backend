package com.ramoys.ems.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ramoys.ems.model.Users;
import com.ramoys.ems.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
	
	public Users registerUser(Users user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return userRepository.save(user); 
	}
}
