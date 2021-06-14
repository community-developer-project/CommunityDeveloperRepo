package com.devcom.boot.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="Response")
public class Response {

	@Column(name="resp_id")
	@Id
	private int respId;

	@Column(name="answer")
	private  String answer;

	@Column(name="resp_date")
	private LocalDate respDate;

	@Column(name="resp_time")
	private LocalTime respTime;

	@Column(name="accuracy")
	private int accuracy;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_dev_id")
	@JsonIgnore
	private Developer developer;

	@ManyToOne
	@JoinColumn(name = "fk_feed_id")
	@JsonIgnore
	private Feed feed;

	public int getRespId() {
		return respId;
	}
	public void setRespId(int respId) {
		this.respId = respId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public LocalDate getRespDate() {
		return respDate;
	}
	public void setRespDate(LocalDate respDate) {
		this.respDate = respDate;
	}
	public LocalTime getRespTime() {
		return respTime;
	}
	public void setRespTime(LocalTime respTime) {
		this.respTime = respTime;
	}
	public int getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}
	public Developer getDeveloper() {
		return developer;
	}
	public void setDeveloper(Developer developer) {
		this.developer = developer;
	}
	public Feed getFeed() {
		return feed;
	}
	public void setFeed(Feed feed) {
		this.feed = feed;
	}

}
