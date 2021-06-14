package com.devcom.boot.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="Feed")
public class Feed{

	@Id
	@Column(name="feed_id")
	private	int feedId;

	@Column(name="query")
	private String query;

	@Column(name="feed_date")
	private LocalDate feedDate;

	@Column(name="feed_time",updatable=false)
	@CreationTimestamp
	private LocalDateTime feedTime;
	
	
	@UpdateTimestamp
	@Column(name="feed_updation_time")
    private LocalDateTime updateDateTime;

	@Column(name="topic")
	private String topic;

	@Column(name="relevance")
	private int  relevance;

	
	
	@ManyToOne
	@JoinColumn(name = "fk_dev_id")
	@JsonBackReference
	private Developer developer;


	@OneToMany(mappedBy="feed",cascade=CascadeType.ALL)
	@JsonIgnore
	private  List<Response> responseList;

	@Column(name = "total_comments")
	private int totalComments;

	public int getFeedId() {
		return feedId;
	}
	public void setFeedId(int feedId) {
		this.feedId = feedId;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public LocalDate getFeedDate() {
		return feedDate;
	}
	public void setFeedDate(LocalDate feedDate) {
		this.feedDate = feedDate;
	}
	
	public LocalDateTime getFeedTime() {
		return feedTime;
	}
	public void setFeedTime(LocalDateTime feedTime) {
		this.feedTime = feedTime;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public int getRelevance() {
		return relevance;
	}
	public void setRelevance(int relevance) {
		this.relevance = relevance;
	}
	
	public Developer getDeveloper() {
		return developer;
	}
	public void setDeveloper(Developer developer) {
		this.developer = developer;
	}
	public List<Response> getResponseList() {
		return responseList;
	}
	public void setResponseList(List<Response> responseList) {
		this.responseList = responseList;
	}
	public int getTotalComments() {
		return totalComments;
	}
	public void setTotalComments(int totalComments) {
		this.totalComments = totalComments;
	}
	
	
	
	
	
	
	public LocalDateTime getUpdateDateTime() {
		return updateDateTime;
	}
	public void setUpdateDateTime(LocalDateTime updateDateTime) {
		this.updateDateTime = updateDateTime;
	}
	@Override
	public String toString() {
		return "Feed [feedId=" + feedId + ", query=" + query + ", feedDate=" + feedDate + ", feedTime=" + feedTime
				+ ", topic=" + topic + ", relevance=" + relevance + ", developer=" + developer + ", responseList="
				+ responseList + ", totalComments=" + totalComments + "]";
	}



}
