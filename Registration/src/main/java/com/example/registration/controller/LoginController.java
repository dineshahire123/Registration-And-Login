package com.example.registration.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.registration.entity.Login;
import com.example.registration.service.LoginService;
import com.example.registration.service.LoginServiceImpl;
import com.example.registration.service.RegistrationServiceImpl;

import jakarta.persistence.Entity;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
    private LoginServiceImpl loginServiceImpl;   
	
	@GetMapping("/get/{username}")
	public ResponseEntity<Optional<Login>> getLoginDetails(@PathVariable("username") String username, @RequestBody Login login)
	{
		Optional<Login> login1 = loginServiceImpl.getLoginDetails(username,login);
		
		return new ResponseEntity<Optional<Login>>(login1,HttpStatus.ACCEPTED);
		
	}
	
	@PostMapping("/check")
    public ResponseEntity<String> loginAccount(@RequestParam String email,@RequestParam String passward, @RequestBody Login login)
    {
		String login2  = loginServiceImpl.loginAccount( email, passward,login);
		
		return new ResponseEntity<String>(login2,HttpStatus.ACCEPTED);
    	
    }
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> logoutAccount(@PathVariable("id") Integer id)
	{
		String logout1 = loginServiceImpl.logoutAccount(id);
		
		return new ResponseEntity<String>(logout1,HttpStatus.ACCEPTED);
		
	}

}
