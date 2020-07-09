package com.example.ecsitedeveloplearning.ec.account.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.ecsitedeveloplearning.ec.account.model.Account;
import com.example.ecsitedeveloplearning.ec.account.repository.AccountRepository;

@Service
public class JpaDetailsServiceImpl implements UserDetailsService{

	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		Account account = accountRepository.findByUserId(userId);
		if(account == null) {
			throw new UsernameNotFoundException("アカウントが見つかりません");
		}
		return account;
	}
	
}
