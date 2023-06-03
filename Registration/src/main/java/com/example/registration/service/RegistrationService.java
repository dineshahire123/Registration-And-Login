package com.example.registration.service;

import java.util.Optional;

import com.example.registration.entity.Registration;

public interface RegistrationService {

	public Optional<Registration>  getRegistrationById(Integer id);
	
	public Registration newRegistration(Registration registration);
	
	public Optional<Registration> updateRegistrationDetails(Registration registration, String email) throws Exception;
}
