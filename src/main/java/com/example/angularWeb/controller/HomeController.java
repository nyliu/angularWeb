package com.example.angularWeb.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.angularWeb.entity.User;
import com.example.angularWeb.service.UserService;

@RestController
public class HomeController {
	
	@Autowired
	private UserService service;
	
	@PostMapping("/saveUser")
	@Transactional
	@CrossOrigin
	public String getRegister(@RequestBody User user) {
		service.saveUser(user);
		return "Hello, welcome to i4Java, your username is: "+user.getUsername();
	}
	
	@GetMapping("/showUser")
	@CrossOrigin
	public Iterable<User> findAllUser(){
		return service.getAllUser();
	}
	
	@GetMapping("/findUser/{username}")
	@Transactional
	@CrossOrigin
	public User getByUsername(@PathVariable String username) {
		return service.findUser(username);
	}
	
	@GetMapping("/delete/{username}")
	@Transactional
	@CrossOrigin
	public Iterable<User> deleteUser(@PathVariable String username){
		service.deleteUser(username);
		return service.getAllUser();
	}
	

}
