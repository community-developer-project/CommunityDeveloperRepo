package com.devcom.boot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.devcom.boot.entity.Developer;
import com.devcom.boot.exception.DeveloperAlreadyExistsException;
import com.devcom.boot.exception.UnknownDeveloperException;


@Service
public interface IDeveloperService {
	Optional<Developer> addDeveloper(Developer dev) throws DeveloperAlreadyExistsException;

	Optional<Developer> editDeveloper(Developer dev) throws UnknownDeveloperException;

	String statusUpdate(Developer dev); // Block Unblock

	Optional<Developer> getDeveloper(int devId) throws UnknownDeveloperException;

	List<Developer> getAllDevelopers();

}
