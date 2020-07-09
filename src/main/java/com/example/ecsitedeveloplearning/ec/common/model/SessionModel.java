package com.example.ecsitedeveloplearning.ec.common.model;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import com.example.ecsitedeveloplearning.ec.account.model.Account;

@Component
@Scope(value="session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String msg;
	
	private Account account;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	};
	
	public void setAccount(String userId, String userName, String password, String email) {
		this.account.setUserId(userId);
		this.account.setUserName(userName);
		this.account.setPassword(password);
		this.account.setEmail(email);
	}
}
