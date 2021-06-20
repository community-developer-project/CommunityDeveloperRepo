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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Feed")
public class Feed {

	@Id
	@Column(name = "feed_id", nullable = false)
	@Min(1000)
	@Max(2000)
	private int feedId;

	@Column(name = "query")
	@NotBlank(message = "Query is mandatory")
	private String query;

	@Column(name = "feed_date")
	private LocalDate feedDate;

	@Column(name = "feed_time", updatable = false)
	@CreationTimestamp
	private LocalDateTime feedTime;

	@UpdateTimestamp
	@Column(name = "feed_updation_time")
	private LocalDateTime updateDateTime;

	@Column(name = "topic")
	@NotBlank(message = "Topic is mandatory")
	private String topic;

	@Column(name = "relevance")
	private int relevance;

	@ManyToOne
	@JoinColumn(name = "fk_dev_id")
	@JsonBackReference
	private Developer developer;

	@OneToMany(mappedBy = "feed", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Response> responseList;

	@Column(name = "total_comments")
	private int totalComments;

	public Feed() {

	}

	public Feed(@Min(1000) @Max(2000) int feedId, @NotBlank(message = "Query is mandatory") String query,
			LocalDate feedDate, LocalDateTime feedTime, LocalDateTime updateDateTime,
			@NotBlank(message = "Topic is mandatory") String topic, int relevance, Developer developer,
			List<Response> responseList, int totalComments) {
		super();
		this.feedId = feedId;
		this.query = query;
		this.feedDate = feedDate;
		this.feedTime = feedTime;
		this.updateDateTime = updateDateTime;
		this.topic = topic;
		this.relevance = relevance;
		this.developer = developer;
		this.responseList = responseList;
		this.totalComments = totalComments;
	}

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
