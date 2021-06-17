package com.devcom.boot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
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
import com.devcom.boot.entity.Feed;
import com.devcom.boot.repository.FeedRepository;
import com.devcom.boot.service.FeedServiceImpl;


@SpringBootTest
class DeveloperCommunityAppApplicationTests {

	@Autowired
	FeedServiceImpl feedService;

	@Autowired
	FeedRepository feedRepo;

	@Mock
	private FeedServiceImpl mockService;


	List<Feed> mock = new ArrayList<>();

	@Test
	void listOfFeedByDev() {
		int myMethod   = feedService.getFeedByDeveloperId(2).size();
		int repoMethod = feedRepo.findAllByDeveloper_DevId(2).size();
		assertEquals(myMethod,repoMethod);
	}

	@Test
	void listOfAllFeed() {
		int myValue =  feedService.getAllFeed().size();
		int actualValue = feedRepo.findAll().size();
		assertEquals(myValue,actualValue);
	}
	
	@Test
	void addFeed() {
		Feed feed = new Feed();
		feed.setFeedId(1000);
		feed.setQuery("what is java");
		feed.setRelevance(10);
		mock.add(feed);
		when(mockService.getAllFeed()).thenReturn(mock);
		assertEquals(mock,mockService.getAllFeed());
	}

}
