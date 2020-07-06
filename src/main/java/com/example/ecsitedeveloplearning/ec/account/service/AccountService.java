package com.example.ecsitedeveloplearning.ec.account.service;

import com.example.ecsitedeveloplearning.ec.account.model.Account;
import com.example.ecsitedeveloplearning.ec.account.model.UserProfile;
import com.example.ecsitedeveloplearning.ec.account.repository.AccountRepository;
import com.example.ecsitedeveloplearning.ec.account.repository.UserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private UserRepository userRepository;
	
	public List<Account> findAll() {
		return accountRepository.findAll();
	};
	
	public Account authCheck(String userId, String password) {
		Account account = new Account();
		account = accountRepository.authCheck(userId, password);
		return account;
	};
	
	public UserProfile getUserProfile(String userId, String password) {
		UserProfile userProfile = userRepository.getUserProfile(userId, password);
		return userProfile;
	}
}
