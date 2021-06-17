package com.devcom.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devcom.boot.entity.Feed;
import com.devcom.boot.entity.Response;
import com.devcom.boot.service.ResponseServiceInterface;

@RestController
@RequestMapping("developerCommunity/response")
public class ResponseController {
	
	@Autowired
	ResponseServiceInterface service;
	
	@PostMapping("save")
	public ResponseEntity<String> saveResponse(@RequestBody Response response){
		 service.addResponse(response);
		 
		 return new ResponseEntity<String>("Response added  Successfully",HttpStatus.OK);
	}
	
	@PutMapping("update")
	public ResponseEntity<String> updateResponse(@RequestBody Response response){
		 service.editResponse(response);
		 
		 return new ResponseEntity<String>("Response Updated Succesfully",HttpStatus.OK);
		
	}

	@DeleteMapping("/delete/{respId}")
	public ResponseEntity<String> deleteResponse(@PathVariable("respId") int respId){
		 service.removeResponse(respId);
		 
		 return new ResponseEntity<String>("Response Deleted Succesfully",HttpStatus.OK);
		
	}
	
	@GetMapping("/feed/{feedId}")
	public ResponseEntity<?> getResponseByFeed(@PathVariable("feedId") int feedId){
		List<Response> listOfResponses = (List<Response>) service.getResponseByFeed(feedId);
		
		return new ResponseEntity<Object>(listOfResponses,HttpStatus.OK);
	}
	
	@GetMapping("/developer/{devId}")
	public ResponseEntity<?> getresponseByDeveloper(@PathVariable("devId") int devId){
		List<Response> listOfResponses = (List<Response>) service.getResponseByDeveloper(devId);
		
		return new ResponseEntity<Object>(listOfResponses,HttpStatus.OK);
	}
}
