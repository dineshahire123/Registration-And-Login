package com.example.registration.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.registration.entity.Registration;
import com.example.registration.repository.RegistrationRepository;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private RegistrationRepository registrationRepository;
	
	@Override
	public Optional<Registration> getRegistrationById(Integer id) {
		// TODO Auto-generated method stub
		
		Optional<Registration>  registration = registrationRepository.findById(id);
		
		
		return registration;
	}

	@Override
	public Registration newRegistration(Registration registration) {
		// TODO Auto-generated method stub
		
		return registrationRepository.save(registration);
	}

	@Override
	public Optional<Registration> updateRegistrationDetails(Registration registration, String email) throws Exception {
		// TODO Auto-generated method stub
		
		Optional<Registration>  updatedRegistration =  Optional.of(registrationRepository.findByEmail(email));
		if(updatedRegistration != null)
		{
	      System.out.println("User is Already there!!");
	      throw new Exception("User is already there !!");
		}
		else
		{
			updatedRegistration.get().setUsername(registration.getUsername());
			 updatedRegistration.get().setName(registration.getName());
			 updatedRegistration.get().setEmail(registration.getEmail());
			 updatedRegistration.get().setPhone(registration.getPhone());
			 updatedRegistration.get().setPassward(registration.getPassward());
			 updatedRegistration.get().setPincode(registration.getPincode());
			 updatedRegistration.get().setState(registration.getState());
			 updatedRegistration.get().setCity(registration.getCity());
		}
		
		return null;
		
	}

}
