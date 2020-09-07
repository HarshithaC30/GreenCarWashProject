package com.carwash.CustomerProfile.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.carwash.CustomerProfile.model.CustomerProfile;

@Repository
public interface CustomerProfileRepository extends MongoRepository<CustomerProfile, String>{

}
