package com.example.user;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.user.domain.User;
import com.example.user.repo.UserRepository;

@Component
public class UserInitializer implements CommandLineRunner {

	private final UserRepository userRepository;

	UserInitializer(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void run(String... args) throws Exception {

		User[] usersArray = { 
				new User("User1", "user1@example.com", "Password1"),
				new User("User2", "user2@example.com", "Password2"),
				new User("User3", "user3@example.com", "Password3") };

		Stream<User> userStream = Stream.of(usersArray);
		userStream.forEach(user -> userRepository.save(user));

		userRepository.findAll().forEach(System.out::println);
	}
}
