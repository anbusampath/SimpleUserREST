package com.example.user.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.dto.LoginRequest;
import com.example.user.dto.LoginResponse;
import com.example.user.repo.UserRepository;
import com.example.user.service.UserService;
import com.example.user.domain.User;

@RestController
public class UserController {

	private final UserService userService;
	private final UserRepository userRepository;

	public UserController(UserService userService, UserRepository userRepository) {
		this.userService = userService;
		this.userRepository = userRepository;
	}

	@PostMapping("/login")
	public LoginResponse login(@RequestBody LoginRequest loginRequest) {
		return userService.validateUserLogin(loginRequest);

	}

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@PostMapping("/user")
	public User createUser(@RequestBody User user) {
		return userRepository.save(user);
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId) {
		User user = userRepository.findOne(userId);
		if (user == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(user);
	}

	@PutMapping("/user/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId, @RequestBody User userDetails) {
		User user = userRepository.findOne(userId);
		if (user == null) {
			return ResponseEntity.notFound().build();
		}
		user.setEmail(userDetails.getEmail());
		user.setName(userDetails.getName());
		user.setPassword(userDetails.getPassword());

		User updatedUser = userRepository.save(user);
		return ResponseEntity.ok(updatedUser);
	}

	@DeleteMapping("/user/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable(value = "id") Long userId) {
		User user = userRepository.findOne(userId);
		if (user == null) {
			return ResponseEntity.notFound().build();
		}

		userRepository.delete(user);
		return ResponseEntity.ok().build();
	}

}
