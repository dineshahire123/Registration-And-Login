package com.example.registration.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.registration.entity.Registration;
import com.example.registration.service.RegistrationServiceImpl;

@RestController
@RequestMapping("/registration")
@CrossOrigin(origins = "http://localhost:4200")
public class RegistrationController {

	@Autowired
	private RegistrationServiceImpl registrationServiceImpl;
    
	@GetMapping("/get/{id}")
	public ResponseEntity<Optional<Registration>> getRegistrationDetails(@PathVariable("id") Integer id)
	{
	   Optional<Registration> registration = registrationServiceImpl.getRegistrationById(id);
		
	return new ResponseEntity<Optional<Registration>>(registration,HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<Registration> newRegistration(@RequestBody Registration registration)
	{
		  
		Registration registration1 = registrationServiceImpl.newRegistration(registration);
		return new ResponseEntity<Registration>(registration1,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/update/{email}")
	public Optional<Registration>  updateRegistrationDetails(@RequestBody Registration registration, @PathVariable("email") String email)
	{
		Optional<Registration> registration2;
		try {
		  registration2 = registrationServiceImpl.updateRegistrationDetails(registration,email);
		  return registration2;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return null;
		
		
	}
   

}
