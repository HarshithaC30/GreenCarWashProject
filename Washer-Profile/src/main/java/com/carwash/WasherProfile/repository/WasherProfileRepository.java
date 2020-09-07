package com.carwash.WasherProfile.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.carwash.WasherProfile.model.WasherProfile;

@Repository
public interface WasherProfileRepository extends MongoRepository<WasherProfile, String>{

}
