package com.example.apiUserInterview.presentation.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.apiUserInterview.persistence.model.Users;
import com.example.apiUserInterview.persistence.repository.UserRepository;

@RestController
public class UserController {
	
	UserRepository repositorio;

	public UserController(UserRepository repositorio) {
		this.repositorio = repositorio;
	}
	
	@GetMapping("/api/users") // C(create)
	public List<Users> obtenerUsers(){
		return repositorio.findAll();
	}
	
	@GetMapping("/api/user/{id}") // Metodo (R) Read 
	public ResponseEntity<Users> obtenerUser(@PathVariable Long id) {
		Optional<Users> opt = repositorio.findById(id);
		
		if (opt.isEmpty()) {
			return ResponseEntity.badRequest().build();
		}
		else {
			return ResponseEntity.ok(opt.get());
		}
	}

	@PostMapping("/api/users") // (C) Create 
	public ResponseEntity<Users> guardarUser(@RequestBody Users user) { 
		
		if (user.getId()!=null) { 
			return ResponseEntity.badRequest().build();
		}
		
		repositorio.save(user); 
		return ResponseEntity.ok(user);
	}
	
	@PutMapping("/api/users") // Metodod (U) Update
	public ResponseEntity<Users> actulizarUser(@RequestBody Users user) { 
		
		if (user.getId()==null || !repositorio.existsById(user.getId()))  
		{
			return ResponseEntity.badRequest().build(); 
		}
		
		repositorio.save(user); 
		return ResponseEntity.ok(user); 
	}

	@DeleteMapping("/api/user/{id}") // Metodod (D) Deleate 
	public ResponseEntity<Users> borrarUser(@PathVariable Long id) { 
		
		if (id == null || !repositorio.existsById(id)) 
		{
			return ResponseEntity.badRequest().build(); 
		}
		
		repositorio.deleteById(id); 
		return ResponseEntity.noContent().build();
	}

}
