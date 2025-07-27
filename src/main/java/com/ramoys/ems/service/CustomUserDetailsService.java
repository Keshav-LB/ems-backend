package com.ramoys.ems.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ramoys.ems.model.UserPrincipal;
import com.ramoys.ems.model.Users;
import com.ramoys.ems.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired 
	UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = userRepository.findByUsername(username);
		
		if(user == null) {
			System.out.println("User Not Found!");
			throw new UsernameNotFoundException(username + "is not found!");
		}
		
		return new UserPrincipal(user);
	}

}
