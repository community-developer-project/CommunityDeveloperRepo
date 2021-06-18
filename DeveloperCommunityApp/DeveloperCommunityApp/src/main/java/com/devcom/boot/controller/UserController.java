package com.devcom.boot.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devcom.boot.entity.Feed;
import com.devcom.boot.entity.User;
import com.devcom.boot.service.UserServiceInterface;

@RestController
@RequestMapping("developerCommunity/user")
public class UserController {
	@Autowired
	UserServiceInterface service;
	
	
	@PostMapping("userLogin")
	public ResponseEntity<String> saveFeed(@Valid @RequestBody User userCredentials){
		String response =  service.checkLogin(userCredentials);
	return new ResponseEntity<String>(response,HttpStatus.OK);
	}
	

	@GetMapping("getLogins")
	public ResponseEntity<?> getEmployees(){

		List<User> list = (List<User>) service.getAllUsers();
		return new ResponseEntity<Object>(list,HttpStatus.OK);
	}
	@GetMapping("{userId}")
	public ResponseEntity<User> getEmployee(@PathVariable("userId") String userId){
		Optional<User> user = service.getUserById(userId);

	return new ResponseEntity<User>(user.get(),HttpStatus.OK);
	}
	
	
	
}