package com.carwash.WasherRegistration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carwash.WasherRegistration.model.Washer;
import com.carwash.WasherRegistration.repository.WasherRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class Controller {
	
	@Autowired
	private WasherRepository repo;
	
	@PostMapping("/washer/register")
		public Washer postWasher(@RequestBody Washer washer) {
			Washer _washer = repo.save(new Washer(washer.getFullname(),washer.getEmail(),washer.getPassword(),washer.getRepeatpassword()));
			return _washer;
	}
	

}
