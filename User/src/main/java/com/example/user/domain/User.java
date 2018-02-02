package com.example.user.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class User {

	public User(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

	@Id
	@GeneratedValue
	private Long id;

	private String name;
	private String email;
	private String password;
	private Date lastLogin;

}