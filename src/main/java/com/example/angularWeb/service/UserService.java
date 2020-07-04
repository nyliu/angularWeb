package com.example.angularWeb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.angularWeb.entity.User;
import com.example.angularWeb.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public User saveUser(User user) {
		return repo.save(user);
	}
	
	public User findUser(String username) {
		return repo.findByUsername(username);
	}
	
	public Iterable<User> getAllUser(){
		return repo.findAll();
	}
	
	public Iterable<User> deleteUser(String username){
		repo.deleteByUsername(username);
		return repo.findAll();
	}

}
