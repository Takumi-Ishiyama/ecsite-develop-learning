package com.example.ecsitedeveloplearning.ec.account.service.Impl;

import java.util.Collection;
import java.util.EnumSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.ecsitedeveloplearning.ec.account.model.Account;
import com.example.ecsitedeveloplearning.ec.account.model.UserType;
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
		Set<UserType> roles;
		roles = EnumSet.of(account.getUserType());
		Collection<? extends GrantedAuthority> authorities = roles.stream()
				.map(role -> new SimpleGrantedAuthority(role.getValue()))
				.collect(Collectors.toList());

		return new User(account.getUserId(), account.getPassword(), authorities);
	}
	
}
