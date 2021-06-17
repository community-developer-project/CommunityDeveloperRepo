package com.devcom.boot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Admin")
public class Admin {

	@Column(name = "admin_id")
	@Id
	private	int adminId;
	@Column(name = "name")
	private	String adName;

	@Column(name = "username")
	private	String adUser;
	
	@Column(name = "password")
	private	String adPassword;

	public int getAdminId() {
		return adminId;
	}

	public void setAdId(int adId) {
		this.adminId = adId;
	}

	public String getAdName() {
		return adName;
	}

	public void setAdName(String adName) {
		this.adName = adName;
	}

	public String getAdUser() {
		return adUser;
	}

	public void setAdUser(String adUser) {
		this.adUser = adUser;
	}

	public String getAdPassword() {
		return adPassword;
	}

	public void setAdPassword(String adPassword) {
		this.adPassword = adPassword;
	}
	
	
	
}
