package com.booking.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RegisterTurf {
	
	@Id
	private long tId;
	private String turfName;
	private long userId;
	private String emailId;
	private String phone;
	
	public RegisterTurf() {
		super();

	}
	public RegisterTurf(long tId, String turfName, long userId, String emailId, String phone) {
		super();
		this.tId = tId;
		this.turfName = turfName;
		this.userId = userId;
		this.emailId = emailId;
		this.phone = phone;
	}
	public long gettId() {
		return tId;
	}
	public void settId(long tId) {
		this.tId = tId;
	}
	public String getTurfName() {
		return turfName;
	}
	public void setTurfName(String turfName) {
		this.turfName = turfName;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
