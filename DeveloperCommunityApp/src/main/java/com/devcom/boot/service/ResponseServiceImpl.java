package com.devcom.boot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devcom.boot.entity.Response;
import com.devcom.boot.exception.NoResponsesFoundException;
import com.devcom.boot.exception.ResponseAlreadyExistsException;
import com.devcom.boot.exception.UnknownResponseException;
import com.devcom.boot.repository.ResponseRepository;

@Service
public class ResponseServiceImpl implements ResponseServiceInterface {
	
	@Autowired
	ResponseRepository responseRepo;

	@Override
	public Optional<Response> addResponse(Response resp) {
		
		
		Optional<Response> response = responseRepo.findById(resp.getRespId());
		if(response.isPresent()) {
			throw new ResponseAlreadyExistsException("Response with response id: " +resp.getRespId() + " already exists:RESPONSE CAN'T BE ADDED");
		}
		responseRepo.save(resp);
		return response; 
	}

	@Override
	public Optional<Response> editResponse(Response resp) {
		Optional<Response> response = responseRepo.findById(resp.getRespId());
		if(!response.isPresent()) {
			throw new UnknownResponseException("Response with id: " + resp.getRespId() + " not present:NO SUCH RESPONSE TO EDIT");
		}
		responseRepo.save(resp);
		return response; 
	}

	@Override
	public Optional<Response> removeResponse(int respId) {
		Optional<Response> response = responseRepo.findById(respId);
		if(!response.isPresent()){
			throw new UnknownResponseException("Response with id: " + respId + " not present:NO SUCH RESPONSE TO DELETE");
		}
		responseRepo.deleteById(respId);
		return response; 
	}

	/*@Override
	public Optional<Response> likeResponse(int respId) {
		// TODO Auto-generated method stub
		return null;
	}*/

	@Override
	public List<Response> getResponseByFeed(int feedId) {
		
		List<Response> listOfResponseByFeed = (List<Response>) responseRepo.findAllByFeed_FeedId(feedId);
		if(listOfResponseByFeed.isEmpty()) {
			throw new NoResponsesFoundException("No Responses found for the feed id: " + feedId);
		}
		return listOfResponseByFeed;
	}

	@Override
	public List<Response> getResponseByDeveloper(int devId) {
		List<Response> listOfResponseByDeveloper = (List<Response>) responseRepo.findAllByDeveloper_DevId(devId);
		if(listOfResponseByDeveloper.isEmpty()) {
			throw new NoResponsesFoundException("No Responses found for the developer id: " + devId);
		}
		return listOfResponseByDeveloper;
	}
	

	
}
