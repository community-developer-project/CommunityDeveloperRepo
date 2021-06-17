package com.devcom.boot.service;

import java.util.List;		
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.devcom.boot.entity.Admin;
import com.devcom.boot.entity.Developer;
import com.devcom.boot.entity.Feed;


@Service
public interface AdminServiceInterface {

	 List<Admin> getAllAdmins();
	Optional<Admin>  getAdminById(Integer adminId);
	Optional<Developer>  getDeveloperById(Integer devId);
	
	Developer  validateDeveloperById(Integer devId);
	Developer  invalidateDeveloperById(Integer devId);
	
	Developer  blockDeveloperById(Integer devId);
	Developer  unblockDeveloperById(Integer devId);
	
	Optional<Feed>  deleteFeedAdmin(Integer feedId);
	
}
