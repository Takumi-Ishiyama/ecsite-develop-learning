package com.example.ecsitedeveloplearning.ec.account.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ecsitedeveloplearning.ec.account.model.Account;
import com.example.ecsitedeveloplearning.ec.account.service.AccountService;

@Controller
@RequestMapping(path="/account")
public class AccountController {
	
	@Autowired
	private AccountService accountService;

	// Top Pageを表示
	@GetMapping("/login")
	public String viewLogin() {
		System.out.println("viewLogin");
		return "account/login";
	}

	//Top Page
	@GetMapping("/findAll")
	public String getAccounts() {
		List<Account> findAll = accountService.findAll();
		System.out.println("findAll :" + findAll);
		System.out.println("viewLogin");
		return "account/login";
	}

	/**
	//認証処理
	@PostMapping("/auth")
	public String authAccount(
				@RequestParam("userId") String userId,
				@RequestParam("password") String password
			) {
		/*
		if(accountService.authCheck(userId, password).equals(null)) {
			return "account/login?error";
		}
		
		accountService.getUserProfile(userId, password);
		return "redirect:/shop/top";
	}
	*/
}
