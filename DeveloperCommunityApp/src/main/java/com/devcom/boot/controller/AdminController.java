package com.devcom.boot.controller;

import java.io.IOException;
import java.util.List;				
import java.util.Optional;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.devcom.boot.entity.Admin;
import com.devcom.boot.entity.Developer;
import com.devcom.boot.entity.Feed;
import com.devcom.boot.entity.Response;
import com.devcom.boot.entity.User;
import com.devcom.boot.service.AdminServiceInterface;

//import jdk.internal.org.jline.utils.Log;

@RestController
@RequestMapping("adminCommunity")
public class AdminController {

	@Autowired
	AdminServiceInterface service;
	
//	------------------List of all admins--------------------------
	@GetMapping("getAdmin") 											
	public ResponseEntity<?> getAdmins(){

		List<Admin> list = (List<Admin>) service.getAllAdmins();
		return new ResponseEntity<Object>(list,HttpStatus.OK);
	}
	
//	------------------Retreive particular admin--------------------------
	@GetMapping("getAdmin/{adminId}")
	public ResponseEntity<Object> getEmployee(@PathVariable("adminId") Integer adminId){
		Optional<Admin> admin = service.getAdminById(adminId);

		return new ResponseEntity<Object>(admin.get(),HttpStatus.OK);
	}

//	------------------Retreive particular developer--------------------------
	@GetMapping("getDev/{devId}")
	public ResponseEntity<Object> getDeveloper(@PathVariable("devId") Integer devId){ 
		Optional<Developer>developer = service.getDeveloperById(devId);
		return new ResponseEntity<Object>(developer.get(),HttpStatus.OK);
		
	}

//	------------------Verify the developer and update user--------------------------	
	@PostMapping("getDev/{devId}/save")
	public ResponseEntity<Object> saveFeed(@RequestBody User user, @PathVariable("devId") Integer devId){
		 //service.saveValidUser(user);
		 Optional<User> developer = service.saveValidUser(user,devId);
	return new ResponseEntity<Object>("Developer vaerified",HttpStatus.OK);
	}
	
//	------------------Revoke validation of a developer--------------------------	
	@GetMapping("getDev/{devId}/revokeValid")
	public ResponseEntity<Object> invalidateDeveloperById(@PathVariable("devId") Integer devId){
		Developer dev = service.invalidateDeveloperById(devId);

		return new ResponseEntity<Object>(dev,HttpStatus.OK);
	}
	
//	------------------Remove a feed--------------------------
	@GetMapping("getFeed") 											
	public ResponseEntity<?> getFeed(){

		List<Feed> list = (List<Feed>) service.getAllFeeds();
		return new ResponseEntity<Object>(list,HttpStatus.OK);
	}
	
//	------------------Remove a feed--------------------------
	@DeleteMapping("getFeed/{feedId}/remove")
	public ResponseEntity<Object> deleteFeed(@PathVariable("feedId") Integer feedId){
		 service.deleteFeedAdmin(feedId);
	return new ResponseEntity<Object>("Feed Removed Successfully",HttpStatus.OK);
	}
	
//	------------------List of response--------------------------
	@GetMapping("getResponse") 											
	public ResponseEntity<?> getResponse(){

		List<Response> list = (List<Response>) service.getAllResponse();
		return new ResponseEntity<Object>(list,HttpStatus.OK);
	}
	
//	------------------Remove a response--------------------------
	@DeleteMapping("getResponse/{respId}/remove")
	public ResponseEntity<Object> deleteResponse(@PathVariable("respId") Integer respId){
		 service.deleteResponseAdmin(respId);
	return new ResponseEntity<Object>("Response Removed Successfully",HttpStatus.OK);
	}
	
//	------------------Block/Unblock a developer--------------------------
	@GetMapping("getDev/{devId}/{choice}")
	public ResponseEntity<Object> blockDeveloper(@PathVariable("devId") Integer devId,@PathVariable("choice") String choice){ 
		Developer developer = service.updateStatusDeveloper(devId,choice);
		return new ResponseEntity<Object>("Developer with "+devId+" is "+choice+"ed",HttpStatus.OK);
		
	}
	
	
//	------------------List of Blocked developers--------------------------
	@GetMapping("getDev/status/{choice}")
	public ResponseEntity<Object> blockDeveloper(@PathVariable("choice") String choice){ 
		List<Developer> list = (List<Developer>) service.getAllIsBlocked(choice);
		return new ResponseEntity<Object>(list,HttpStatus.OK);
		
	}
	
//	------------------send mail to the developer when verified--------------------------
//	@GetMapping(value = "/simple-email/{user-email}")
//    public @ResponseBody ResponseEntity<?> sendSimpleEmail(@PathVariable("user-email") String email) {
//
//        try {
//            service.sendSimpleEmail(email, "Welcome", "This is a welcome email for your!!");
//        } catch (MailException mailException) {
// 
////            LOG.error("Error while sending out email..{}", mailException.getStackTrace());
//            return new ResponseEntity<>("Unable to send email", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//
//        return new ResponseEntity<>("Please check your inbox", HttpStatus.OK);
//    }
//	
//	@RequestMapping(value = "/sendemail")
//	public String sendEmail() throws AddressException, MessagingException, IOException {
//	   sendEmail();
//	   return "Email sent successfully";   
//	}
}
