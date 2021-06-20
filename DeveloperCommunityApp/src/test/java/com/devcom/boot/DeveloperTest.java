package com.devcom.boot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.devcom.boot.controller.DeveloperController;
import com.devcom.boot.entity.Developer;
import com.devcom.boot.entity.Feed;
import com.devcom.boot.exception.DeveloperAlreadyExistsException;
import com.devcom.boot.exception.UnknownDeveloperException;
import com.devcom.boot.repository.DeveloperRepository;
import com.devcom.boot.service.DeveloperServiceImpl;
import com.devcom.boot.service.IDeveloperService;

@SpringBootTest

public class DeveloperTest {

	@Autowired
	DeveloperController con;
	
	@Autowired
	IDeveloperService service;

	@Autowired
	DeveloperRepository devRepo;

	@Mock
	IDeveloperService dao;

	@Mock
	private DeveloperServiceImpl mockService;

	List<Developer> mock = new ArrayList<>();

	@Test
	void DeveloperMail() {
		Developer dev = devRepo.findByDevId(1);
		assertEquals(dev.getEmail(), "sam@gmail.com");
	}

	@Test
	void listOfAllDevelopers() {
		int myValue = devRepo.findAll().size();
		int actualValue = service.getAllDevelopers().size();
		assertEquals(myValue, actualValue);
	}

	@Test
	void checkByDeveloperId() {
		Developer dev = new Developer();
		dev.setDevId(2);
		Developer dev1 = devRepo.findByDevId(2);
		assertEquals(2, dev1.getDevId());
	}

	@Test
	void testAddDeveloper() throws DeveloperAlreadyExistsException {
		Developer dev = new Developer();
		dev.setDevId(6);
		dev.setName("vikas");
		dev.setSkillLevel("beginner");
		dev.setEmail("vikas123@gmail.com");
		dev.setMemberSince(LocalDate.of(2020, 12, 10));
		dev.setIsBlocked(false);
		dev.setIsVerified(true);
		dev.setTotalFeeds(0);
		List<Feed> feedList = new ArrayList<>();
		LocalDate date = LocalDate.of(2017, 1, 13);
		LocalDateTime rightNow = LocalDateTime.now();
		assertThrows(DeveloperAlreadyExistsException.class,()->service.addDeveloper(dev));

	}
	

}
