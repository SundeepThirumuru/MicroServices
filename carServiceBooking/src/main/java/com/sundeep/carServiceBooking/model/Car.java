package com.sundeep.carServiceBooking.model;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Car {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String carRegNo;
	
	public String getCarRegNo() {
		return carRegNo;
	}
	
	public void setCarRegNo(String carRegNo) {
		this.carRegNo = carRegNo;
	}
	
	private int customerId;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public String getCustomerIdAsString() {
		return getCustomerId() > 0 ? Integer.toString(getCustomerId()) : "";
	}
	
	public String getCustomerName(Map<Integer, Customer> customerMap) {
		if(customerMap.containsKey(getCustomerId())) {
			return customerMap.get(getCustomerId()).getName();
		}
		return getCustomerId() > 0 ? "Customer Data Unavailable" : "Not Associated to Any Customer";
	}
	
	@ElementCollection
	private List<Integer> customerIds;
	
	public List<Integer> getCustomerIds() {
		return customerIds;
	}
	
	public void setCustomerIds(List<Integer> customerIds) {
		this.customerIds = customerIds;
	}

	public String getCustomerIdsAsString() {
		if(customerIds != null && !customerIds.isEmpty()) {
			return customerIds.toString();
		}
		return getCustomerId() > 0 ? Integer.toString(getCustomerId()) : "";
	}
	
	public String getCustomerNames(Map<Integer, Customer> customerMap) {
		if(customerIds != null && !customerIds.isEmpty()) {
			String customerNames  = "";
			List<Integer> customerDataNAList = new ArrayList<>();
			for(Integer customerId : customerIds) {
				if(customerMap.containsKey(customerId)) {
					customerNames = (customerNames.isEmpty() ? customerNames : (customerNames + ", ")) + customerMap.get(customerId).getName();
				}
				else {
					customerDataNAList.add(customerId);
				}
			}
			if(!customerDataNAList.isEmpty()) {
				customerNames = (customerNames.isEmpty() ? customerNames : (customerNames + ", ")) + customerDataNAList.toString() + ": Customer Data Unavailable";
			}
			return customerNames;
		}
		else if(customerMap.containsKey(getCustomerId())) {
			return customerMap.get(getCustomerId()).getName();
		}
		return getCustomerId() > 0 ? "Customer Data Unavailable" : "Not Associated to Any Customer";
	}	
}
