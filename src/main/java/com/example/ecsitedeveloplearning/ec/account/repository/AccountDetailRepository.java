package com.example.ecsitedeveloplearning.ec.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.ecsitedeveloplearning.ec.account.model.AccountDetail;

@Repository
public interface AccountDetailRepository extends JpaRepository<AccountDetail, Long>{

	public AccountDetail findByUserId(String userId);
	
	@Modifying
	@Transactional
	@Query(value="update account_details ad setad.firstName = ?2, ad.lastName = ?3, ad.postcode = ?4, ad.address1 = ?5, ad.address2 = ?6, ad.buildingName = ?7, ad.telephoneNumber = ?8 where ad.userId = ?1;", nativeQuery = true)
	void saveAccount(
			String userId,
			String firstName,
			String lastName,
			String postcode,
			String address1,
			String address2,
			String buildingName,
			String telephoneNumber);
}
