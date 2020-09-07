package com.carwash.adminlogin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carwash.adminlogin.model.AdminLogin;
import com.carwash.adminlogin.repository.Repository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class Controller {
	
	@Autowired
	Repository repo;
	
	@PostMapping("/admin/login")
	AdminLogin validateAdmin(@RequestBody AdminLogin userlog) {
		List<AdminLogin> login=repo.findAll();
		for(AdminLogin log:login) {
			if(log.getEmail().equals(userlog.getEmail()) && log.getPassword().equals(userlog.getPassword()))
				return log;
		    }
		
		return null;
	
	}

}
