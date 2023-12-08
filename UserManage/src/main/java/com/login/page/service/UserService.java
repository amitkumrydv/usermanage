package com.login.page.service;

import com.login.page.model.UserDtls;

public interface UserService {
	
	
	public UserDtls createUser(UserDtls user);
	
	public boolean checkEmail(String email);
	
	

}
