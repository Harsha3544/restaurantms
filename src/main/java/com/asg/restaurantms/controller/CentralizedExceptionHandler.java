package com.asg.restaurantms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.asg.restaurantms.exceptions.InvalidCredentialException;
import com.asg.restaurantms.exceptions.NoRecordsFoundException;
import com.asg.restaurantms.exceptions.RestaurantAlreadyExistException;
import com.asg.restaurantms.exceptions.UserAlreadyExistException;
import com.asg.restaurantms.exceptions.UserNotFoundException;

@RestControllerAdvice
public class CentralizedExceptionHandler {

	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler({
		UserNotFoundException.class,
		NoRecordsFoundException.class})	
	public String handleNotFoundExceptions(Exception e){
		String msg = e.getMessage();
		return msg;
	}
	
	@ResponseStatus(HttpStatus.ALREADY_REPORTED)
	@ExceptionHandler({UserAlreadyExistException.class,RestaurantAlreadyExistException.class})	
	public String handleAlreadyExistException(Exception e){
		String msg = e.getMessage();
		return msg;
	}
	
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ExceptionHandler(InvalidCredentialException.class)	
	public String handleInvalidException(InvalidCredentialException e){
		String msg = e.getMessage();
		return msg;
	}
	
	
	
}
