package com.asg.restaurantms.service;

import java.util.List;

import com.asg.restaurantms.entity.Restaurant;
import com.asg.restaurantms.exceptions.InvalidTokenException;
import com.asg.restaurantms.exceptions.NoRecordsFoundException;
import com.asg.restaurantms.exceptions.RestaurantAlreadyExistException;

public interface RestaurantService {

	public String addRestaurant(Restaurant restaurant,String token) throws RestaurantAlreadyExistException, InvalidTokenException;
	
	public List<Restaurant> searchByRestaurentName(String name) throws NoRecordsFoundException;
	
	public List<Restaurant> searchByRestaurentCity(String city) throws NoRecordsFoundException;
	
	public List<Restaurant> searchByRestaurentState(String state) throws NoRecordsFoundException;
	
}
