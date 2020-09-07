package com.carwash.CustomerProfile.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carwash.CustomerProfile.exception.ResourceNotFoundException;
import com.carwash.CustomerProfile.model.CustomerProfile;
import com.carwash.CustomerProfile.repository.CustomerProfileRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CustomerProfileController {
	
	@Autowired
	private CustomerProfileRepository profileRepository;
	
	@GetMapping("/profile")
	public List<CustomerProfile> getAllProfile() {
		return profileRepository.findAll();
	}
	
	
	  @GetMapping("/profile/{id}") public ResponseEntity<CustomerProfile>
	  getEmployeeById(@PathVariable(value = "id") String id) throws
	  ResourceNotFoundException { CustomerProfile profile =
	  profileRepository.findById(id) .orElseThrow(() -> new
	  ResourceNotFoundException("Profile not found for this id :: " +
	  id)); return ResponseEntity.ok().body(profile); }
	 
	
	@PostMapping("/profile")
    public CustomerProfile createProfile(@RequestBody CustomerProfile profile) {
        return profileRepository.save(profile);
    }
	
	@PutMapping("/profile/{id}")
    public ResponseEntity<CustomerProfile> updateProfile(@PathVariable(value = "id") String id,
        @RequestBody CustomerProfile profileDetails) throws ResourceNotFoundException {
		CustomerProfile profile = profileRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Profile not found for this id :: " + id));

		profile.setName(profileDetails.getName());
		profile.setEmail(profileDetails.getEmail());
		profile.setPhoneno(profileDetails.getPhoneno());
		profile.setLocation(profileDetails.getLocation());
        final CustomerProfile updatedProfile = profileRepository.save(profile);
        return ResponseEntity.ok(updatedProfile);
    }
	
//	@DeleteMapping("/profile/{id}")
//    public Map<String, Boolean> deleteProfile(@PathVariable(value = "id") String id)
//         throws ResourceNotFoundException {
//		CustomerProfile profile = profileRepository.findById(id)
//       .orElseThrow(() -> new ResourceNotFoundException("Profile not found for this id :: " + id));
//
//		profileRepository.delete(profile);
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("deleted", Boolean.TRUE);
//        return response;
//    }
	@DeleteMapping("/profile/{id}")
		public ResponseEntity<String> deleteProfile(@PathVariable("id") String id){
		System.out.println("Delete Customer with id=" + id + "..." );
		profileRepository.deleteById(id);
		return new ResponseEntity<>("Customer has been deleted", HttpStatus.OK);
	}

}
