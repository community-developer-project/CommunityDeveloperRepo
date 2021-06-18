package com.devcom.boot.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.devcom.boot.entity.Feed;
import com.devcom.boot.exception.FeedNotFoundException;
import com.devcom.boot.repository.FeedRepository;


@Service
public class FeedServiceImpl implements FeedServiceInterface {

	@Autowired 
	FeedRepository feedRepo;

	@Override
	public Optional<Feed> getFeedById(int feedId) {

		Optional<Feed> feed = feedRepo.findById(feedId);
		if(!feed.isPresent())
			throw new FeedNotFoundException("Feed With Id "+ feedId +" Not Found");
		return feed;
	}

	@Override
	public Optional<Feed> saveFeed(Feed feed) {
		Optional<Feed> existing = feedRepo.findById(feed.getFeedId());
		
		if(!existing.isPresent()) {
			feedRepo.save(feed);
			return existing;
		}
		throw new FeedNotFoundException("Feed With Id "+ feed.getFeedId() +" exists already");

	}

	@Override
	public Optional<Feed> deleteFeedById(int feedId) {

		Optional<Feed> feed = feedRepo.findById(feedId);
		if(!feed.isPresent())
			throw new FeedNotFoundException("Feed With Id "+ feedId +" Not Found");
		feedRepo.deleteById(feedId);
		return feed;
	}

	@Override
	public Optional<Feed> updateFeed(Feed feed) {
		Optional<Feed> existing = feedRepo.findById(feed.getFeedId());
		if(existing.isPresent()) {
			feedRepo.save(feed);
			return existing;
		}
		throw new FeedNotFoundException("Feed With Id "+ feed.getFeedId() +" Not Exist");

	}

	@Override
	public List<Feed> getFeedByDeveloperId(int feedId) {
		List<Feed> listOfFeedByDev = (List<Feed>) feedRepo.findAllByDeveloper_DevId(feedId);
		return listOfFeedByDev;
	}

	@Override
	public List<Feed> getFeedByTopic(String topic) {
		List<Feed> listOfFeedByTopic = (List<Feed>) feedRepo.findAllByTopic(topic);
		return listOfFeedByTopic;
	}

	@Override
	public List<Feed> getFeedByKeyword(String keyword) {
		List<Feed> listOfFeedByKeyword = (List<Feed>) feedRepo.findByKeyword(keyword);
		return listOfFeedByKeyword;
		
	}


}
