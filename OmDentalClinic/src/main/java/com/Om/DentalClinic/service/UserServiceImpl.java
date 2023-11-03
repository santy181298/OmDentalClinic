package com.Om.DentalClinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Om.DentalClinic.model.User;
import com.Om.DentalClinic.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userrepo;
	
	public UserServiceImpl(UserRepository userrepo) {
		super();
		this.userrepo = userrepo;
	}

	@Override
	public User findByUsername(String username) {
		
		return userrepo.findByUsername(username);
	}

	@Override
	public boolean checkUsername(String username) {
		
		return userrepo.existsByUsername(username);
	}
	
	
	public void saveUser(User user) {
		
	    this.userrepo.save(user);
	}
	
}
