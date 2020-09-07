package com.carwash.CustomerLogin.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carwash.CustomerLogin.model.Customer;
import com.carwash.CustomerLogin.repository.Repository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class Controller {
	
	@Autowired
	Repository repo;
	
	@PostMapping("/customer/login")
	Customer validateCustomer(@RequestBody Customer userlog) {

	//System.out.println(userlog);
		List<Customer> login=repo.findAll();
		//System.out.println(login);
	//	System.out.println(login);
		for(Customer log:login) {
			//System.out.println(dblog.getEmail()+" "+userlog.getEmail());
			if(log.getEmail().equals(userlog.getEmail()) && log.getPassword().equals(userlog.getPassword()))
				return log;
		    }
		
		return null;
	}

}
