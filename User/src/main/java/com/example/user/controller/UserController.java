package com.example.user.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.dto.LoginRequest;
import com.example.user.dto.LoginResponse;
import com.example.user.repo.UserRepository;
import com.example.user.service.UserService;

@RestController
public class UserController {

	private final UserService userService;

	public UserController(UserService userService, UserRepository userRepository) {
		this.userService = userService;
	}

	@PostMapping("/login")
	public LoginResponse login(@RequestBody LoginRequest loginRequest) {
		return userService.validateUserLogin(loginRequest);

	}

}
