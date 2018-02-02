package com.example.user.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.example.user.domain.User;
import com.example.user.dto.LoginRequest;
import com.example.user.dto.LoginResponse;
import com.example.user.repo.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepository;
	
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public LoginResponse validateUserLogin(LoginRequest loginRequest) {
		
		LoginResponse loginResponse = new LoginResponse();
		
		User user = userRepository.findByEmail(loginRequest.getEmail());
		if( user != null && user.getPassword().equals(loginRequest.getPassword())) {
			loginResponse.setLoginStaus(true);
			user.setLastLogin(new Date());
			userRepository.save(user);
		}else {
			loginResponse.setLoginStaus(false);
			loginResponse.setErrorMessage("Invalid UserName/Password");
		}
		return loginResponse;
		
	}

}
