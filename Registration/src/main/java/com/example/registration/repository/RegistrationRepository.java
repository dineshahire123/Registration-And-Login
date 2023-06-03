package com.example.registration.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.registration.entity.Registration;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Integer>{
    
	public Registration findByEmail(String email);

	Optional<Registration> findByEmailAndPassward(String email, String passward);

	

	
}
