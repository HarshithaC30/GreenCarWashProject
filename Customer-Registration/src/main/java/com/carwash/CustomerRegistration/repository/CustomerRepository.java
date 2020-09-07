package com.carwash.CustomerRegistration.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.carwash.CustomerRegistration.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String>{

}
