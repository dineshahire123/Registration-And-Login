package com.example.registration.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.registration.entity.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer>{

	Optional<Login> findByUsername(String username);

}
