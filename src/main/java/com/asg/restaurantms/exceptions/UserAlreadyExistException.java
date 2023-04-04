package com.asg.restaurantms.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.ALREADY_REPORTED)
public class UserAlreadyExistException extends Exception {

	public UserAlreadyExistException(String msg) {
		super(msg);
		
	}
	
	
}
