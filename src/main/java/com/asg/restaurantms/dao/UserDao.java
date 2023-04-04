package com.asg.restaurantms.dao;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.asg.restaurantms.entity.User;

@Repository
public interface UserDao extends CrudRepository<User,String>{

		public Optional<User> findByUserName(String userName);
		
}
