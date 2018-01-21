package com.sundeep.customerDataReacter;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sundeep.customerDataReacter.model.Car;

interface CarRepository extends CrudRepository<Car, Integer> {

	@Query("Select c from Car c where c.customerId = :customerId")
	public Iterable<Car> findCarsByCustomerId(@Param("customerId") Integer customerId);

}
