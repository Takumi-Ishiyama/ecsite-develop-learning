package com.example.ecsitedeveloplearning.ec.account.model;

import lombok.Getter;

public enum Gender {

	man("男性"),
	woman("女性");
	
	@Getter
	private String value;
	
	private Gender(String value) {
		this.value = value;
	}
}
