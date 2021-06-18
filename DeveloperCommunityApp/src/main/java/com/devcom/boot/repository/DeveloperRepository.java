package com.devcom.boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;	
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.devcom.boot.entity.Developer;


public interface DeveloperRepository extends CrudRepository<Developer,Integer> {

	
	Developer findByDevId(int devId);
	List<Developer> findAllByIsBlocked(Boolean val);
	

}
