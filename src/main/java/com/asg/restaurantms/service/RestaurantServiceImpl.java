package com.asg.restaurantms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asg.restaurantms.dao.RestaurantDao;
import com.asg.restaurantms.dao.UserDao;
import com.asg.restaurantms.entity.Restaurant;
import com.asg.restaurantms.entity.User;
import com.asg.restaurantms.exceptions.InvalidTokenException;
import com.asg.restaurantms.exceptions.NoRecordsFoundException;
import com.asg.restaurantms.exceptions.RestaurantAlreadyExistException;
import com.asg.restaurantms.exceptions.UserAlreadyExistException;
import com.asg.restaurantms.util.TokenUtil;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private RestaurantDao restaurantDao;
	
	@Autowired
	TokenUtil tokenUtil;
	
	@Autowired
	UserDao userDao;
	
	@Override
	public String addRestaurant(Restaurant restaurant, String token) throws RestaurantAlreadyExistException, InvalidTokenException {
		
		String userName = tokenUtil.decodeToken(token);
		
		Optional<User> optionalUser = userDao.findByUserName(userName);
		
		if(!optionalUser.isPresent() || !optionalUser.get().isAdmin() ) {
			return "access denied";
		}
		
		Optional<Restaurant> optional = restaurantDao.findById(restaurant.getRestaurantId());

		if(optional.isPresent()) {
			throw new RestaurantAlreadyExistException("Restaurant already exists");
		}
		Restaurant savedRestaurant = restaurantDao.save(restaurant);
		return savedRestaurant.toString();

	}

	@Override
	public List<Restaurant> searchByRestaurentName(String name) throws NoRecordsFoundException {
		Optional<List<Restaurant>> optional = restaurantDao.findByName(name);
		if(optional.get().size()==0) {
			throw new NoRecordsFoundException("No Restaurants with name"+name);
		}
		return optional.get();
	}

	@Override 
	public List<Restaurant> searchByRestaurentCity(String city) throws NoRecordsFoundException {
		Optional<List<Restaurant>> optional = restaurantDao.findByCity(city);
		if(optional.get().size()==0) {
			throw new NoRecordsFoundException("No Restaurants found in "+city);
		}
		return optional.get();
	}

	@Override
	public List<Restaurant> searchByRestaurentState(String state) throws NoRecordsFoundException {
		Optional<List<Restaurant>> optional = restaurantDao.findByState(state);
		if(optional.get().size()==0) {
			throw new NoRecordsFoundException("No Restaurants in "+state);
		}
		return optional.get();
	}

}
