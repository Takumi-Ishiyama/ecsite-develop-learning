package com.example.ecsitedeveloplearning.ec.account.model;

import lombok.Getter;

public enum UserType {
	
	admin("ADMIN"),
	user("USER");
	
	@Getter
	private String value;
	
	private UserType(String value) {
		this.value = value;
	}
}
