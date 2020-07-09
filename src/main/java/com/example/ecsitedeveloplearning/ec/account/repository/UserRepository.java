package com.example.ecsitedeveloplearning.ec.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.ecsitedeveloplearning.ec.account.model.UserProfile;

@Repository
public interface UserRepository extends JpaRepository<UserProfile, Long>{
	@Query(value = "SELECT "
			+ "id as id, "
			+ "user_type as userType"
			+ "user_id as userId, "
			+ "user_name as userName, "
			+ "password as password, "
			+ "email as email"
			+ "FROM rosso_ec.accounts "
			+ "WHERE "
			+ "user_id = ?1, "
			+ "password = ?2"
			, nativeQuery = true)
	public UserProfile getUserProfile(String userId, String password);
}
