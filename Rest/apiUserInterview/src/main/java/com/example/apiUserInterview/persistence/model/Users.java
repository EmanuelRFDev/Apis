package com.example.apiUserInterview.persistence.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	String name;
	String lastname;
	String ocupation;
	
	public Users() {
		super();
	}

	public Users(String name, String lastname, String ocupation) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.ocupation = ocupation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return name;
	}

	public void setTitulo(String name) {
		this.name = name;
	}

	public String getDirector() {
		return lastname;
	}

	public void setDirector(String lastname) {
		this.lastname = lastname;
	}

	public String getGenero() {
		return ocupation;
	}

	public void setGenero(String ocupation) {
		this.ocupation = ocupation;
	}
	
	
	

}
