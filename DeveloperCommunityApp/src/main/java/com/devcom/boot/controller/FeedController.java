package com.devcom.boot.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.devcom.boot.entity.Feed;
import com.devcom.boot.entity.User;
import com.devcom.boot.service.FeedServiceInterface;

@RestController
@RequestMapping("developerCommunity/feed")
public class FeedController {

	@Autowired
	FeedServiceInterface service;

	@PostMapping("save")
	public ResponseEntity<String> saveFeed(@RequestBody Feed feed) {
		service.saveFeed(feed);
		return new ResponseEntity<String>("Feed Added Successfully", HttpStatus.OK);
	}

	@GetMapping("{feedId}")
	public ResponseEntity<Feed> getFeed(@PathVariable("feedId") int feedId) {
		Optional<Feed> feed = service.getFeedById(feedId);

		return new ResponseEntity<Feed>(feed.get(), HttpStatus.OK);
	}

	@GetMapping("/developer/{devId}")
	public ResponseEntity<?> getFeedByDeveloper(@PathVariable("devId") int devId) {
		List<Feed> listOfFeeds = (List<Feed>) service.getFeedByDeveloperId(devId);

		return new ResponseEntity<Object>(listOfFeeds, HttpStatus.OK);
	}

	@GetMapping("/topic/{topic}")
	public ResponseEntity<?> getFeedByTopic(@PathVariable("topic") String topic) {
		List<Feed> listOfTopics = (List<Feed>) service.getFeedByTopic(topic);

		return new ResponseEntity<Object>(listOfTopics, HttpStatus.OK);
	}

	@GetMapping("/keyword/{keyword}")
	public ResponseEntity<?> getFeedByKeyword(@PathVariable("keyword") String keyword) {
		List<Feed> listOfKeyword = (List<Feed>) service.getFeedByKeyword(keyword);

		return new ResponseEntity<Object>(listOfKeyword, HttpStatus.OK);
	}

	@DeleteMapping("{feedId}")
	public ResponseEntity<String> deleteFeed(@PathVariable("feedId") int feedId) {
		service.deleteFeedById(feedId);
		return new ResponseEntity<String>("Feed Deleted Succesfully", HttpStatus.OK);

	}

	@PutMapping("update")
	public ResponseEntity<String> updateFeed(@RequestBody Feed feed) {
		service.updateFeed(feed);
		return new ResponseEntity<String>("Feed Updated Succesfully", HttpStatus.OK);

	}

}
