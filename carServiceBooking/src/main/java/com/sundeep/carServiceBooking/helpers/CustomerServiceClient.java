package com.sundeep.carServiceBooking.helpers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.sundeep.carServiceBooking.model.Customer;

@Component
public class CustomerServiceClient {

	RestTemplate restTemplate = new RestTemplate();
	private int NUM_OF_RETRIES = 2;

	public Customer getCustomer(int id) {
		return get(String.format("http://localhost:8081/getCustomer?id=%d", id), Customer.class);
	}

	public List<Customer> getAllCustomers() {
		Customer[] customers = get("http://localhost:8081/getAllCustomers", Customer[].class);

		List<Customer> customerList = new ArrayList<>();
		if (customers != null) {
			for (Customer customer : customers) {
				customerList.add(customer);
			}
		}
		return customerList;
	}

	public <T> T get(String url, Class<T> clazz) {
		T result = null;
		boolean isSuccessful = false;
		int tryCount = 0;
		while (!isSuccessful && tryCount < NUM_OF_RETRIES) {
			try {
				result = restTemplate.getForObject(url, clazz);
				isSuccessful = true;
			} catch (Exception e) {

			}
			tryCount ++;
		}
		return result;
	}
}
