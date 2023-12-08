package com.login.page.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.page.model.UserDtls;
import com.login.page.repository.UserRepository;
import com.login.page.service.UserService;


@Service
public class UserServiceImpl implements UserService {
	
	
	
	@Autowired
	private UserRepository userRepo;
	

	@Override
	public UserDtls createUser(UserDtls user) {
		
		
		return userRepo.save(user);
	}


	@Override
	public boolean checkEmail(String email) {
		
		
		
		return userRepo.existsByEmail(email);
	}
	
	

}
