package com.devcom.boot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devcom.boot.entity.User;
import com.devcom.boot.exception.UserNotFoundException;
import com.devcom.boot.repository.UserRepository;

@Service
public class UserServiceImpl implements UserServiceInterface{


	@Autowired UserRepository userRepo;

	@Override
	public List<User> getAllUsers() {
		List<User> listOfUsers = (List<User>) userRepo.findAll();
		return listOfUsers;
	}

	@Override
	public Optional<User> getUserById(String UserId) {
		
		Optional<User> user = userRepo.findById(UserId);
		if(!user.isPresent())
			throw new UserNotFoundException("User With Id "+ UserId+" Not Found");
		return user;
	}


}
