package com.carwash.WasherLogin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carwash.WasherLogin.model.Washer;
import com.carwash.WasherLogin.repository.Repository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class Controller {
	
	@Autowired
	Repository repo;
	
	@PostMapping("/washer/validate")
	Washer validateWasher(@RequestBody Washer userlog) {

		//System.out.println(userlog);
			List<Washer> login=repo.findAll();
			//System.out.println(login);
		//	System.out.println(login);
			for(Washer log:login) {
				//System.out.println(dblog.getEmail()+" "+userlog.getEmail());
				if(log.getEmail().equals(userlog.getEmail()) && log.getPassword().equals(userlog.getPassword()))
					return log;
			    }
			
			return null;
	}

}
