package com.abel.crud.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abel.crud.example.entity.User;
import com.abel.crud.example.repository.UserRepo;
import com.abel.crud.example.service.UserService;


@CrossOrigin
@RestController
public class UserController {

	@Autowired
	private UserService service;
	
	@Autowired
	private UserRepo repo;
	
	public boolean islogged = false;
	
	@GetMapping("/")
	public String loginuser(Model model) {
		User user = new User();
		model.addAttribute(user);
		return "login";
		
	}
			
	@PostMapping("/register")
	public User register(@RequestBody User user){
	
		return service.addUser(user);
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User userdata) {
			
		User user = service.findUserByEmail(userdata.getEmail());
		if(user.getPass().equals(userdata.getPass())) {
			return ResponseEntity.ok(user);
		
		}
		else {
			return (ResponseEntity<?>) ResponseEntity.internalServerError();	
		}
		
		}
}
