package com.devcom.boot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.devcom.boot.entity.Feed;
import com.devcom.boot.repository.FeedRepository;

public class FeedListByIdTest {

	
	@Autowired
	FeedRepository feedRepo;
	
	@Test
	void testAdd() {
		
		List<Feed> listOfFeedByDev  = 	feedRepo.findAllByDeveloper_DevId(2);
		assertEquals(2,listOfFeedByDev.size());
	}
	
}
