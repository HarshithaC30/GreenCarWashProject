package com.carwash.CustomerProfile.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Profile")
public class CustomerProfile {
	
	private String id;
	private String name;
	private String email;
	private long phoneno;
	private String location;
	
	public CustomerProfile() {
		
	}

	public CustomerProfile(String name, String email, long phoneno, String location) {
		super();
		this.name = name;
		this.email = email;
		this.phoneno = phoneno;
		this.location = location;
	}
	
	

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(long phoneno) {
		this.phoneno = phoneno;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "CustomerProfile [name=" + name + ", email=" + email + ", phoneno=" + phoneno
				+ ", location=" + location + "]";
	}
	

}
