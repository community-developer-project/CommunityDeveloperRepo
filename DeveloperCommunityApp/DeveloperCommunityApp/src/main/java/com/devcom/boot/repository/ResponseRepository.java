package com.devcom.boot.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.devcom.boot.entity.Developer;
import com.devcom.boot.entity.Feed;
import com.devcom.boot.entity.Response;

public interface ResponseRepository extends CrudRepository<Response,Integer> {
	
		
	List<Response> findAllByFeed_FeedId(int feedId);
	List<Response> findAllByDeveloper_DevId(int devId);

}
