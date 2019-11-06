package com.doctormanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doctormanagement.model.User;
import com.doctormanagement.repository.UserRepository;

@RestController
public class testClass {
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("api/auth/testit")
	public String testing() {
		userRepository.save(new User("nayeem","nayeemah","nayeemaj@gmail.com","kkkklala"));
		return "accessed";
	}
}
