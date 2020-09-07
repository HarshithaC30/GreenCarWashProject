package com.carwash.CustomerRegistration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carwash.CustomerRegistration.model.Customer;
import com.carwash.CustomerRegistration.repository.CustomerRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class Controller {
	
	@Autowired
	private CustomerRepository repo;
	
	 @PostMapping("/customer/register")
		public Customer postWasher(@RequestBody Customer customer) {

		 Customer _customer = repo.save(new Customer(customer.getFullname(),customer.getEmail(),customer.getPassword(),customer.getRepeatpassword()));
			return _customer;
		}

}
