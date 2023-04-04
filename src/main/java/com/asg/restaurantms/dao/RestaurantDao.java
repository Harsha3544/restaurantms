package com.asg.restaurantms.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.asg.restaurantms.entity.Restaurant;

@Repository
public interface RestaurantDao extends CrudRepository<Restaurant,String> {

	
	public Optional<List<Restaurant>> findByName(String restaurantName);
	
	public Optional<List<Restaurant>> findByRestaurantId(String restaurantId);
	
	public Optional<List<Restaurant>> findByCity(String city);
	
	public Optional<List<Restaurant>> findByState(String state);
	
}
