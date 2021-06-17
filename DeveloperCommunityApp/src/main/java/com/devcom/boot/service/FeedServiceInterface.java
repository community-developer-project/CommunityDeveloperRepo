package com.devcom.boot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.devcom.boot.entity.Feed;
import com.devcom.boot.entity.User;

@Service
public interface FeedServiceInterface {
	
	
	List<Feed> getAllFeed();
	
	List<Feed> getFeedByDeveloperId(int feedId);
	
	List<Feed> getFeedByTopic(String topic);
	
	List<Feed> getFeedByKeyword(String keyword);
	
	Optional<Feed> getFeedById(int feedId);
	
	Optional<Feed> deleteFeedById(int feedId);
	
	Optional<Feed> saveFeed( Feed feed);
	
	Optional<Feed> updateFeed( Feed feed);

}
