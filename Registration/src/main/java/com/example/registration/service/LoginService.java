package com.example.registration.service;

import java.util.Optional;

import com.example.registration.entity.Login;

public interface LoginService {

	public Optional<Login> getLoginDetails(String username, Login login);
	
	public String loginAccount(String email,String passward, Login login);
	
	public String logoutAccount(Integer id);
}
