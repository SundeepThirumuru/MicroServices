package com.sundeep.customerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sundeep.customerService.model.Customer;

@RestController
public class CustomerRestController {

	@Autowired
	CustomerRepository customerRepository;
	
	@RequestMapping("/getCustomer")
	public Customer getCustomer(@RequestParam(name="id", defaultValue="-1") int id) {
		if(customerRepository.exists(id)) {
			return customerRepository.findOne(id);
		}
		return null;
	}

	@RequestMapping("/getAllCustomers")	
	public Iterable<Customer> getAllCustomerIds(){
		return customerRepository.findAll();
	}
}
