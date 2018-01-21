package com.sundeep.carServiceBooking;

import org.springframework.data.repository.CrudRepository;

import com.sundeep.carServiceBooking.model.Car;

public interface CarRepository extends CrudRepository<Car, Integer> {

}
