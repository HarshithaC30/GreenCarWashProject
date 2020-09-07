package com.carwash.adminlogin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.carwash.adminlogin.model.AdminLogin;

public interface Repository extends MongoRepository<AdminLogin, String>{

}
