package com.example.ecsitedeveloplearning.ec.account.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class UserProfile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "userType")
	private UserType userType;
	
	@Column(name = "userId", unique = true)
	private String userId;
	
	@Column(name = "userName")
	private String userName; 

	@Column(name = "password")
	private String password;
	
	@Column(name = "email")
	private String email;
	
	public UserProfile(Long id, UserType userType, String userId, String userName, String password, String email) {
		this.id = id;
		this.userType = userType;
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.email = email;
	}
} 
