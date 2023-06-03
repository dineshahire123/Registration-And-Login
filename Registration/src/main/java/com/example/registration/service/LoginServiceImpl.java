package com.example.registration.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.registration.entity.Login;
import com.example.registration.entity.Registration;
import com.example.registration.repository.LoginRepository;
import com.example.registration.repository.RegistrationRepository;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginRepository loginrRepository;
	
	@Autowired
	private RegistrationRepository registrationRepository;
	
	@Override
	public Optional<Login> getLoginDetails(String username, Login login) {
		// TODO Auto-generated method stub
		
		Optional<Login> login1 = loginrRepository.findByUsername(username);
		
		return login1;
	}

	@Override
	public String loginAccount( String email,String passward,Login login) {
		// TODO Auto-generated method stub
		
		Optional<Registration> registrationDetails = registrationRepository.findByEmailAndPassward(email,passward);
		
		if(!registrationDetails.isPresent())
		{
			return "Wrong Credentials";
		}
		
	    return "Login Successfully";
	}

	@Override
	public String logoutAccount(Integer id) {
		// TODO Auto-generated method stub
		
		Optional<Registration> registration1 = registrationRepository.findById(id);
		
		if(!registration1.isPresent())
		{
			return "User is not Logged in With this Credentials";
		}
		
		Registration registration = registration1.get();
		
        registrationRepository.delete(registration);
			
		return "Logout Successfully";
		
	    
	}

	
}
