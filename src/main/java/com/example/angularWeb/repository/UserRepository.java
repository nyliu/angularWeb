package com.example.angularWeb.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.angularWeb.entity.User;

public interface UserRepository extends CrudRepository<User, Integer>{
	
	public User findByUsername(String username);
	
	public Iterable<User> deleteByUsername(String username);

}
