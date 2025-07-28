package com.ramoys.ems.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ramoys.ems.model.Users;
import com.ramoys.ems.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JWTService jwtService;
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
	
	public Users registerUser(Users user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return userRepository.save(user); 
	}
	
	public String verifyUser(Users user) {
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		if(authentication.isAuthenticated()) {
			return jwtService.generateToken(user.getUsername());
		}
		return "failed!";
	}
}
