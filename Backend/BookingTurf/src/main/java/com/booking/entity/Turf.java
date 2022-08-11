package com.booking.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Turf {
	
	@Id
	private long tId;
	private String turfName;
	private Double turfPrice;
	
	public Turf() {
		super();

	}
	public Turf(int tId, String turfName, Double turfPrice) {
		super();
		this.tId = tId;
		this.turfName = turfName;
		this.turfPrice = turfPrice;
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
	public Double getTurfPrice() {
		return turfPrice;
	}
	public void setTurfPrice(Double turfPrice) {
		this.turfPrice = turfPrice;
	}
	
	

}
