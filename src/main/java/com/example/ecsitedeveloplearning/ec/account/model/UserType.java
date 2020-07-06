package com.example.ecsitedeveloplearning.ec.account.model;

import lombok.Getter;

public enum UserType {
	
	ROLE_ADMIN("admin"),
	ROLE_USER("user");
	
	@Getter
	private String value;
	
	private UserType(String value) {
		this.value = value;
	}
}
