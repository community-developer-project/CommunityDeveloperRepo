package com.devcom.boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.devcom.boot.entity.Feed;

@Repository
public interface FeedRepository extends JpaRepository<Feed,Integer> {

	
	List<Feed> findAllByDeveloper_DevId(int devId);
	List<Feed> findAllByTopic(String topic);
}
