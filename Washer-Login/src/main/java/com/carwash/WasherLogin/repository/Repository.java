package com.carwash.WasherLogin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.carwash.WasherLogin.model.Washer;

public interface Repository extends MongoRepository<Washer, String>{

}
