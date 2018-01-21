package com.sundeep.customerDataReacter.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private int id;
	
	private String carRegNo;
	
	private int customerId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCarRegNo() {
		return carRegNo;
	}

	public void setCarRegNo(String carRegNo) {
		this.carRegNo = carRegNo;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
}
