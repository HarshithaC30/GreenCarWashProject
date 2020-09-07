package com.carwash.CustomerLogin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.carwash.CustomerLogin.model.Customer;

public interface Repository extends MongoRepository<Customer, String>{

}
