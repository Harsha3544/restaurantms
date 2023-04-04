package com.asg.restaurantms.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="restaurantdb")
@Entity
public class Restaurant{
	
	private String name;
	
	@Id
	private String restaurantId;
	
	private String city;
	
	private String state;
	
	public Restaurant() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(String restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Restaurant [name=" + name + ", restaurantId=" + restaurantId + ", city=" + city + ", state=" + state
				+ "]";
	}

	

	
}