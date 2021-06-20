package com.devcom.boot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.devcom.boot.entity.Developer;
import com.devcom.boot.exception.DeveloperAlreadyExistsException;
import com.devcom.boot.exception.UnknownDeveloperException;
import com.devcom.boot.repository.IDeveloperRepository;

@Service
public class DeveloperServiceImpl implements IDeveloperService {
	@Autowired
	IDeveloperRepository devRepo;

	@Override
	public Optional<Developer> addDeveloper(Developer dev) throws DeveloperAlreadyExistsException {
		Optional<Developer> existing = devRepo.findById(dev.getDevId());
		if (existing.isPresent()) {

			throw new DeveloperAlreadyExistsException("Developer With Id " + dev.getDevId() + " exists already");
		}
		devRepo.save(dev);
		return existing;
	}

	@Override
	public Optional<Developer> editDeveloper(Developer dev) throws UnknownDeveloperException {
		Optional<Developer> existing = devRepo.findById(dev.getDevId());
		if (!(existing.isPresent())) {
			throw new UnknownDeveloperException("Developer With Id " + dev.getDevId() + " Not Exist");

		}
		devRepo.save(dev);
		return existing;
	}

	@Override
	public String statusUpdate(Developer dev) {
		boolean checkStatus = dev.getIsVerified();
		dev.setIsVerified(checkStatus);
		boolean checkStatus2 = dev.getIsBlocked();
		dev.setIsBlocked(checkStatus2);
		System.out.println(checkStatus);
		System.out.println(checkStatus2);
		return "Status of Developer With Id " + dev.getDevId() + " Updated";

	}

	public Optional<Developer> getDeveloper(int devId) throws UnknownDeveloperException {
		Optional<Developer> dev = devRepo.findById(devId);
		if (!dev.isPresent())
			throw new UnknownDeveloperException("Developer With Id " + devId + " Not Exist");
		return dev;
	}

	@Override
	public List<Developer> getAllDevelopers() {
		List<Developer> listOfDevelopers = (List<Developer>) devRepo.findAll();
		return listOfDevelopers;

	}

}
