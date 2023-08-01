package com.abel.crud.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abel.crud.example.entity.User;
import com.abel.crud.example.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo repository;
	
	public User findUserByEmail(String email) {
		
		return repository.findByEmail(email);
	}
	
	public User addUser(User user) {
		return repository.save(user);
		
	}
}
