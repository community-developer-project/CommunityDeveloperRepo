package com.devcom.boot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.devcom.boot.entity.Feed;
import com.devcom.boot.repository.FeedRepository;
import com.devcom.boot.service.FeedServiceImpl;

@SpringBootTest
class DeveloperCommunityAppApplicationTests {

	@Autowired
	FeedServiceImpl feedService;
	
	@Test
	void listOfFeedByDev() {
		List<Feed> listOfFeedByDev  = feedService.getFeedByDeveloperId(2);
		assertEquals(2,listOfFeedByDev.size());
	}
}
