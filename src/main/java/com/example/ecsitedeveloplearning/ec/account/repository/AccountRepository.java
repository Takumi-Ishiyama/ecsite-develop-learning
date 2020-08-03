package com.example.ecsitedeveloplearning.ec.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.ecsitedeveloplearning.ec.account.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
	// ここはDBに Access するためのRepositoryです。
	// JPaを extendsして設定する必要があります。
//	@Query(value = "select * from rosso_ec.accounts where userId = ?1 and password = ?2", nativeQuery = true)
//	public Account authCheck(String userId, String password);

	public Account findByUserId(String userId);
	
}
