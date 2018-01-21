package com.sundeep.customerService;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;

import com.sundeep.customerService.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

	@Override
	@Cacheable(cacheNames = "customers")
	Iterable<Customer> findAll();
	
	@SuppressWarnings("unchecked")
	@Override
	@CacheEvict(cacheNames = "customers", allEntries=true)
	Customer save(Customer customer);
	
	@Override
	@CacheEvict(cacheNames = "customers", allEntries=true)
	void delete(Integer id);	
	
	@Override
	@Cacheable(cacheNames = "customers", key="#p0")
	Customer findOne(Integer id);
	
}
