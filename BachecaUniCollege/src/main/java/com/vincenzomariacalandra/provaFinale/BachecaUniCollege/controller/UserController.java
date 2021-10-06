package com.vincenzomariacalandra.provaFinale.BachecaUniCollege.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vincenzomariacalandra.provaFinale.BachecaUniCollege.model.User;
import com.vincenzomariacalandra.provaFinale.BachecaUniCollege.service.UserService;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {
	
	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping
	public Iterable<User> listAllUsers () {
		return userService.getUsers();
	}
	
	@PostMapping
	public User registerNewUser (@RequestBody User user) {
		return userService.addUser(user);
	}
	
	@DeleteMapping(path = "/{userId}")
	public void deleteUser(@PathVariable("userId") long userId) {
		userService.removeUser(userId);
	}
	
	@PutMapping(path = "/{userId}")
	public User updateUser (@PathVariable("userId") long userId, 
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String surname,
			@RequestParam(required = false) String email) {
		
		return userService.updateUser(userId, name, surname, email);
	}
	
	
	@RequestMapping(method =RequestMethod.POST, path = "/test" )
	public User addUserExample () {
		return userService.addUserExample();
	}
}
