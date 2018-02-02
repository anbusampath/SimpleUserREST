package com.example.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.user.domain.User;

//@RepositoryRestResource
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByEmail(String email);
}
