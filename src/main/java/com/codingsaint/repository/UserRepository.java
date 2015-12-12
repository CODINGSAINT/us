package com.codingsaint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.codingsaint.domain.User;

public interface UserRepository extends JpaRepository<User, String> {
	@Transactional(readOnly = true)
	@Query("SELECT u FROM User u WHERE LOWER(u.username) = LOWER(:username)")
	User findByUsernameCaseInsensitive(@Param("username") String username);

	@Query
	User findByEmail(String email);

	@Query
	User findByEmailAndActivationKey(String email, String activationKey);

	@Query
	User findByEmailAndResetPasswordKey(String email, String resetPasswordKey);

}