package com.devcom.boot.service;

import java.io.IOException;
import java.net.PasswordAuthentication;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;	
import java.util.Optional;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


import com.devcom.boot.entity.Admin;
import com.devcom.boot.entity.Developer;
import com.devcom.boot.entity.Feed;
import com.devcom.boot.entity.Response;
import com.devcom.boot.entity.User;
import com.devcom.boot.exception.AdminNotFoundException;
import com.devcom.boot.exception.FeedNotFoundException;
import com.devcom.boot.exception.NoResponsesFoundException;
import com.devcom.boot.exception.UserNotFoundException;
import com.devcom.boot.repository.AdminRepository;
import com.devcom.boot.repository.DeveloperRepository;
import com.devcom.boot.repository.FeedRepository;
import com.devcom.boot.repository.ResponseRepository;
import com.devcom.boot.repository.UserRepository;

@Service
public class AdminServiceImpl implements AdminServiceInterface{
	
	@Autowired AdminRepository adminRepo;
	@Autowired DeveloperRepository devRepo;
	@Autowired FeedRepository feedRepo;
	@Autowired UserRepository userRepo;
	@Autowired JavaMailSender emailSender;
	@Autowired ResponseRepository responseRepo;
	
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
	public Optional<User> saveValidUser(User user,Integer devId) {
		Optional<User> existing = userRepo.findById(user.getUserId());
		Developer exists = devRepo.findByDevId(devId);
		
		 if(exists == null)
				throw  new AdminNotFoundException("Developer With Id "+ devId+" Not Found");
			boolean value = exists.getIsVerified();
			
			if(!value) {
				  
				  exists.setIsVerified(true);
			 	  devRepo.save(exists);
			 	 if(!existing.isPresent()) {
						userRepo.save(user);
						return existing;
					}
					throw new UserNotFoundException("User With Id "+ user.getUserId() +" exists already");
			 	  
			 }
			 else 
				 throw new AdminNotFoundException("blabla With Id "+ devId+" Not Found");	
	}
	@Override
	public Developer invalidateDeveloperById(Integer devId) {
		Developer exists = devRepo.findByDevId(devId);
		 if(exists == null)
		throw  new AdminNotFoundException("Devloper With Id "+ devId+" Not Found");
	boolean value = exists.getIsVerified();
	
		 if(value) {
			  
			  exists.setIsVerified(false);
		 	  devRepo.save(exists);
		 }
		 else 
			 throw new AdminNotFoundException("Devloper With Id "+ devId+" Not Found");
		return exists;
				
	}
	
	@Override
	public Developer updateStatusDeveloper(Integer devId, String choice) {
		Developer exists = devRepo.findByDevId(devId);
		 if(exists == null)
		throw  new AdminNotFoundException("Devloper With Id "+ devId+" Not Found");
	boolean value = exists.getIsBlocked();
	
		switch(choice) {
		case "block": if(value) {
			  
			  			exists.setIsBlocked(false);
						 	  devRepo.save(exists);
						 }
						 else 
							 throw new AdminNotFoundException("Devloper With Id "+ devId+" Not Found");
						return exists;
		
		case "unblock":	if(!value) {
			  
						  exists.setIsBlocked(true);
					 	  devRepo.save(exists);
					 }
					 else 
						 throw new AdminNotFoundException("Devloper With Id "+ devId+" Not Found");
					return exists;
					
		default: throw new AdminNotFoundException("block/unblock");
		}
		
	}
	@Override
	public Optional<Feed> deleteFeedAdmin(Integer feedId) {
		Optional<Feed> existing = feedRepo.findById(feedId);
		
		if(existing.isPresent()) {
			feedRepo.deleteById(feedId);
			return existing;
		}
		else
			throw new FeedNotFoundException("Feed With Id "+ feedId +" does not exist");
		
	}
//	@Override
//	public void sendSimpleEmail(String email, String string, String string2) {
//		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//		  simpleMailMessage.setTo(email);
//		  simpleMailMessage.setSubject("checkmail");
//		  simpleMailMessage.setText("Check if this mail is recieved");
//		  simpleMailMessage.setFrom("nishanthylakshmipathy72@gmail.com");
//		  
//		  
//		  emailSender.send(simpleMailMessage);
//	}
	@Override
	public List<Feed> getAllFeeds() {
		
		List<Feed> listOfFeeds = (List<Feed>) feedRepo.findAll();
		return listOfFeeds;
	}
/*	
	@Override
	public void sendemail() throws AddressException, MessagingException, IOException{
		
		   Properties props = new Properties();
		   props.put("mail.smtp.auth", "true");
		   props.put("mail.smtp.starttls.enable", "true");
		   props.put("mail.smtp.host", "smtp.gmail.com");
		   props.put("mail.smtp.port", "587");
		   
		   Session session = Session.getInstance(props, new javax.mail.Authenticator() {
		      protected PasswordAuthentication getPasswordAuthentication() {
		         return new PasswordAuthentication("nishanthylakshmipathy72@gmail.com", "luckmahinishi");
		      }
		   });
		   Message msg = new MimeMessage(session);
		   msg.setFrom(new InternetAddress("nishanthyalakshmipathy72@gmail.com", false));
		   
		   msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("mahinishi@gmail.com"));
		   msg.setSubject("Tutorials point email");
		   msg.setContent("Tutorials point email", "text/html");
		   msg.setSentDate(new Date());

		   MimeBodyPart messageBodyPart = new MimeBodyPart();
		   messageBodyPart.setContent("Tutorials point email", "text/html");

		   Multipart multipart = new MimeMultipart();
		   multipart.addBodyPart(messageBodyPart);
		  
		   msg.setContent(multipart);
		   Transport.send(msg); 
		
	}
	
*/
	@Override
	public List<Response> getAllResponse() {
		List<Response> listOfresp = (List<Response>) responseRepo.findAll();
		return listOfresp;
	}
	@Override
	public Optional<Response> deleteResponseAdmin(Integer respId) {
		Optional<Response> existing = responseRepo.findById(respId);
		
		if(existing.isPresent()) {
			responseRepo.deleteById(respId);
			return existing;
		}
		else
			throw new NoResponsesFoundException("Response With Id "+ respId +" does not exist");
	}
	@Override
	public List<Developer> getAllIsBlocked(String choice) {
		List<Developer> listOfdev = (List<Developer>) devRepo.findAllByIsBlocked(true);
		List<Developer> falseList= (List<Developer>) devRepo.findAllByIsBlocked(false);
	
		if(choice.equals("Blocked")) {
			return listOfdev;
		}
		else if(choice.equals("UnBlocked")) {
			return falseList;
		}
		else
			throw new NoResponsesFoundException("Use only Blocked/Unblocked");
	}
	
	
	
	
	
		
}
