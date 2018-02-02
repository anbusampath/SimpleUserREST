package com.example.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.user.domain.User;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByEmail(String email);
}
