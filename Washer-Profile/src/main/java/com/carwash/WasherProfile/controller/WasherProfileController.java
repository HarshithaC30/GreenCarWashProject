package com.carwash.WasherProfile.controller;

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

import com.carwash.WasherProfile.exception.ResourceNotFoundException;
import com.carwash.WasherProfile.model.WasherProfile;
import com.carwash.WasherProfile.repository.WasherProfileRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class WasherProfileController {
	@Autowired
	private WasherProfileRepository profileRepository;
	
	@GetMapping("/washerprofile")
	public List<WasherProfile> getAllProfile() {
		return profileRepository.findAll();
	}
	
	
	  @GetMapping("/washerprofile/{id}") public ResponseEntity<WasherProfile>
	  getProfileById(@PathVariable(value = "id") String id) throws
	  ResourceNotFoundException { WasherProfile profile =
	  profileRepository.findById(id) .orElseThrow(() -> new
	  ResourceNotFoundException("Profile not found for this id :: " +
	  id)); return ResponseEntity.ok().body(profile); }
	 
	
	@PostMapping("/washerprofile")
    public WasherProfile createProfile(@RequestBody WasherProfile profile) {
        return profileRepository.save(profile);
    }
	
	@PutMapping("/washerprofile/{id}")
    public ResponseEntity<WasherProfile> updateProfile(@PathVariable(value = "id") String id,
        @RequestBody WasherProfile profileDetails) throws ResourceNotFoundException {
		WasherProfile profile = profileRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Profile not found for this id :: " + id));

		profile.setName(profileDetails.getName());
		profile.setEmail(profileDetails.getEmail());
		profile.setPhoneno(profileDetails.getPhoneno());
		profile.setLocation(profileDetails.getLocation());
        final WasherProfile updatedProfile = profileRepository.save(profile);
        return ResponseEntity.ok(updatedProfile);
    }
	
//	@DeleteMapping("/profile/{id}")
//    public Map<String, Boolean> deleteProfile(@PathVariable(value = "id") String id)
//         throws ResourceNotFoundException {
//		WasherProfile profile = profileRepository.findById(id)
//       .orElseThrow(() -> new ResourceNotFoundException("Profile not found for this id :: " + id));
//
//		profileRepository.delete(profile);
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("deleted", Boolean.TRUE);
//        return response;
//    }
	
	@DeleteMapping("/washerprofile/{id}")
	public ResponseEntity<String> deleteProfile(@PathVariable("id") String id){
	System.out.println("Delete Washer with id=" + id + "..." );
	profileRepository.deleteById(id);
	return new ResponseEntity<>("Washer has been deleted", HttpStatus.OK);
}

}
