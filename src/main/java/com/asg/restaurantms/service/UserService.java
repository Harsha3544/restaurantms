package com.asg.restaurantms.service;


import com.asg.restaurantms.entity.User;
import com.asg.restaurantms.entity.UserAuth;
import com.asg.restaurantms.exceptions.InvalidCredentialException;
import com.asg.restaurantms.exceptions.UserAlreadyExistException;
import com.asg.restaurantms.exceptions.UserNotFoundException;

public interface UserService {

	
	public String saveUser(User user) throws UserAlreadyExistException;
	
	public String userLogin(UserAuth user) throws InvalidCredentialException;
	
	
}
