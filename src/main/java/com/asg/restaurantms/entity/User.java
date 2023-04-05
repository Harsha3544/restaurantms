package com.asg.restaurantms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

@Table(name="users")
@Entity
public class User {

	@NotNull(message="name required")
	private String name;

	@Id
	@NotNull(message="User name required")
	private String userName;
	
	@NotNull(message="email required")
	private String email;
	
	@NotNull(message="Phone number required")
	private String phoneNumber;
	
	@NotNull(message="password required")
	@Size(min=7,max=15,message="message=\"Password must be equal to or greater than 7 characters and less than 15 ")
	private String password;
	
	private boolean isAdmin=false;
	
	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public User() {
		
	}

	public User(String name, String userName, String email, String phoneNumber, String password) {
		super();
		this.name = name;
		this.userName = userName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String loginId) {
		this.userName = loginId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", userName=" + userName + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", password=" + password + "]";
	}
	
	
	
}
