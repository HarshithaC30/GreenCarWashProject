package com.carwash.adminlogin.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Admin")
public class AdminLogin {
	
	private String email;
	private String password;
	
		
	public AdminLogin() {
		
	}

	public AdminLogin(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
