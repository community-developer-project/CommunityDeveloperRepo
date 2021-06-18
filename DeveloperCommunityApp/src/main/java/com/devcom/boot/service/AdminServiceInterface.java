package com.devcom.boot.service;

import java.util.List;			
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.devcom.boot.entity.Admin;
import com.devcom.boot.entity.Developer;
import com.devcom.boot.entity.Feed;
import com.devcom.boot.entity.User;


@Service
public interface AdminServiceInterface {

	 List<Admin> getAllAdmins();											/*list of all admins*/
	Optional<Admin>  getAdminById(Integer adminId);							/*Particular admin details*/
	Optional<Developer>  getDeveloperById(Integer devId);					/*Particular developer details*/
	
	Optional<User>  saveValidUser(User user,Integer devId);					/*Validate developer and update user*/
	Developer  invalidateDeveloperById(Integer devId);						/*Revoke validation*/
	
	Developer  updateStatusDeveloper(Integer devId,String choice);			/*Block or Unblock developer*/
	
	List<Feed> getAllFeeds();											    /*list of all Feeds*/
	Optional<Feed>  deleteFeedAdmin(Integer feedId);						/*Delete Feed*/
	
	void sendSimpleEmail(String email, String string, String string2);		/*Send mail*/
	
	
}
