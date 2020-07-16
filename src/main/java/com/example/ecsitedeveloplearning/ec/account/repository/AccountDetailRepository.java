package com.example.ecsitedeveloplearning.ec.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ecsitedeveloplearning.ec.account.model.AccountDetail;

@Repository
public interface AccountDetailRepository extends JpaRepository<AccountDetail, Long>{

	public AccountDetail findByUserId(String userId);
	
}
