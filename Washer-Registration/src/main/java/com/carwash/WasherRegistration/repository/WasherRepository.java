package com.carwash.WasherRegistration.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.carwash.WasherRegistration.model.Washer;

public interface WasherRepository extends MongoRepository<Washer, String>{

}
