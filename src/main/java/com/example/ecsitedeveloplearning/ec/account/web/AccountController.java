package com.example.ecsitedeveloplearning.ec.account.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ecsitedeveloplearning.ec.account.service.AccountService;

@Controller
@RequestMapping(path="/account")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	// Top Page
	@GetMapping("/login")
	public String viewLogin() {
		System.out.println("viewLogin");
		return "account/login";
	}

}
