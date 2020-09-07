package com.carwash.WasherRegistration.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Washer")
public class Washer {

	private String fullname;
	private String email;
	private String password;
	private String repeatpassword;
	
	public Washer() {
		
	}

	public Washer(String fullname, String email, String password, String repeatpassword) {
		this.fullname = fullname;
		this.email = email;
		this.password = password;
		this.repeatpassword = repeatpassword;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
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

	public String getRepeatpassword() {
		return repeatpassword;
	}

	public void setRepeatpassword(String repeatpassword) {
		this.repeatpassword = repeatpassword;
	}
	
		
	
}
