package com.example.ecsitedeveloplearning.ec.account.service;
import com.example.ecsitedeveloplearning.ec.account.model.AccountDetail;
import com.example.ecsitedeveloplearning.ec.account.repository.AccountDetailRepository;
import com.example.ecsitedeveloplearning.ec.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private AccountDetailRepository accountDetailRepository;
	
	public AccountDetail getAccountDetail(String userId) {
		return accountDetailRepository.findByUserId(userId);
	}
	/**
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
	**/
}
