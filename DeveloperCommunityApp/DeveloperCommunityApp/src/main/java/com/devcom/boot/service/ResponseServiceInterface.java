package com.devcom.boot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.devcom.boot.entity.Response;
import com.devcom.boot.exception.NoResponsesFoundException;
import com.devcom.boot.exception.UnknownResponseException;

@Service
public interface ResponseServiceInterface {
	Optional<Response> addResponse(Response resp);
	
	Optional<Response> editResponse(Response resp);
	
	Optional<Response> removeResponse(int respId) throws UnknownResponseException;
	
	//Optional<Response> likeResponse(int respId);
	
	List<Response> getResponseByFeed(int feedId) throws NoResponsesFoundException;
	
	List<Response> getResponseByDeveloper(int devId) throws NoResponsesFoundException ;
}
