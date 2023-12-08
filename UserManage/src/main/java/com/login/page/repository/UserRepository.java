package com.login.page.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.login.page.model.UserDtls;

public interface UserRepository extends JpaRepository<UserDtls, Integer>{
	
	
           public boolean existsByEmail(String email);
}

