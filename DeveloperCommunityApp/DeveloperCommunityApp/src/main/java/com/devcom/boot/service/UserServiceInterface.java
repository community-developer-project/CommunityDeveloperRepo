package com.devcom.boot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.devcom.boot.entity.User;

@Service
public interface UserServiceInterface {

	List<User>getAllUsers();
	
	Optional<User>  getUserById(String UserId);
	
	String checkLogin(User userCredentials);
}
