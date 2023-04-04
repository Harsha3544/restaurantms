package com.asg.restaurantms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asg.restaurantms.entity.Restaurant;
import com.asg.restaurantms.exceptions.InvalidTokenException;
import com.asg.restaurantms.exceptions.NoRecordsFoundException;
import com.asg.restaurantms.exceptions.RestaurantAlreadyExistException;
import com.asg.restaurantms.service.RestaurantService;

@RestController
@RequestMapping("restaurant")
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;
	
	@PostMapping("/addrestaurant")
	public String addRestaurant(
			@RequestBody Restaurant restaurant,
			@RequestHeader(HttpHeaders.AUTHORIZATION) String token) 
					throws RestaurantAlreadyExistException, InvalidTokenException {
		String result = restaurantService.addRestaurant(restaurant,token);
		return result;
	}
	
	@GetMapping("name/{name}")
	public List<Restaurant>  findByRestaurantByName(@PathVariable String name) throws NoRecordsFoundException {
		
		List<Restaurant> result = restaurantService.searchByRestaurentName(name);
		return result;
	}
	
	@GetMapping("city/{city}")
	public List<Restaurant> findByRestaurantByCity(@PathVariable String city) throws NoRecordsFoundException {
		
		List<Restaurant> result = restaurantService.searchByRestaurentCity(city);
		return result;
	}
	
	@GetMapping("state/{state}")
	public List<Restaurant>  findByRestaurantByState(@PathVariable String state) throws NoRecordsFoundException {
		
		List<Restaurant> result = restaurantService.searchByRestaurentState(state);
		return result;
	}
	
	
	
}
