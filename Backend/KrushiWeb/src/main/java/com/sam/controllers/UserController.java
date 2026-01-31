package com.sam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sam.models.User;
import com.sam.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin("*")
public class UserController 
{
	@Autowired
	UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody @Valid User user)
	{
		return userService.register(user);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User user)
	{
		return userService.login(user.getEmail(), user.getPassword());
	}


}
