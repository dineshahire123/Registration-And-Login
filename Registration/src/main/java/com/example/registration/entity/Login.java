package com.example.registration.entity;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Login {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	
}
