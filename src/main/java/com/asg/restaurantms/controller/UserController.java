package com.asg.restaurantms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.asg.restaurantms.entity.User;
import com.asg.restaurantms.entity.UserAuth;
import com.asg.restaurantms.exceptions.InvalidCredentialException;
import com.asg.restaurantms.exceptions.UserAlreadyExistException;
import com.asg.restaurantms.service.UserService;

@RestController
@RequestMapping("app/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/register")
	public String registerUser(@RequestBody @Valid User user) throws UserAlreadyExistException {
		
		String result = userService.saveUser(user);
		return result;
	}
	
	@PostMapping("/login")
	public String userLogin(@RequestBody @Valid UserAuth user) throws InvalidCredentialException {
		
		String result = userService.userLogin(user);
		return result;
	}
	
	
	
	
}
