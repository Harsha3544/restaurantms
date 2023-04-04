package com.asg.restaurantms.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asg.restaurantms.dao.UserDao;

import com.asg.restaurantms.entity.User;
import com.asg.restaurantms.entity.UserAuth;
import com.asg.restaurantms.exceptions.InvalidCredentialException;
import com.asg.restaurantms.exceptions.UserAlreadyExistException;
import com.asg.restaurantms.exceptions.UserNotFoundException;
import com.asg.restaurantms.util.TokenUtil;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Autowired
	TokenUtil tokenUtil;
	
	@Override
	public String saveUser(User user) throws UserAlreadyExistException {
		
			Optional<User> optional = userDao.findByUserName(user.getUserName());
			if(optional.isPresent()) {
				throw new UserAlreadyExistException("User already exists");
			}
			User savedUser = userDao.save(user);
			return savedUser.toString();
	}

	@Override
	public String userLogin(UserAuth user) throws InvalidCredentialException {
		Optional<User> optional = userDao.findByUserName(user.getUserName());
		if(!optional.isPresent()) {
			throw new InvalidCredentialException("Invalid User Name");
		}
		if(!optional.get().getPassword().equals(user.getPassword())) {
			throw new InvalidCredentialException("Invalid  Password");
		}
		String token = tokenUtil.generateToken(user.getUserName());
		return token;
	}

	
			
}
