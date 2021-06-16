package com.devcom.boot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devcom.boot.entity.Admin;
import com.devcom.boot.entity.Developer;
import com.devcom.boot.entity.User;
import com.devcom.boot.exception.AdminNotFoundException;
import com.devcom.boot.exception.UserNotFoundException;
import com.devcom.boot.repository.AdminRepository;
import com.devcom.boot.repository.DeveloperRepository;

@Service
public class AdminServiceImpl implements AdminServiceInterface{
	
	@Autowired AdminRepository adminRepo;
	@Autowired DeveloperRepository devRepo;
	
	public List<Admin> getAllAdmins() {
		List<Admin> listOfAdmins = (List<Admin>) adminRepo.findAll();
		return listOfAdmins;
	}
	public Optional<Admin> getAdminById(Integer adminId) {
		
		Optional<Admin> admin = adminRepo.findById(adminId);
		if(!admin.isPresent())
			throw new AdminNotFoundException("Admin With Id "+ adminId+" Not Found");
		return admin;
	}
	
	public Optional<Developer> getDeveloperById(Integer devId) {
		Optional<Developer> developer = devRepo.findById(devId);
		
//		  if(!developer.isPresent()) throw new
//		  DeveloperNotFoundException("Developer With Id "+ devId+" Not Found");
		 
		return developer;
	}
	
	
	@Override
	public Developer validateDeveloperById(Integer devId) {
		Developer exists = devRepo.findByDevId(devId);
		 if(exists == null)
		throw  new AdminNotFoundException("Devloper With Id "+ devId+" Not Found");

	boolean value = exists.getIsVerified();
	
		 if(value) {
			  exists.setIsVerified(false);
		 	  devRepo.save(exists);
		 }
		 else 
			 exists.setIsVerified(true);
		 		devRepo.save(exists);
		return exists;
		
		
	}
	
}
