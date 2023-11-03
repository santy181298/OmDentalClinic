package com.Om.DentalClinic.service;

import com.Om.DentalClinic.model.User;

public interface UserService {
	
	User findByUsername(String username);
	
	public boolean checkUsername(String username);
	
}
