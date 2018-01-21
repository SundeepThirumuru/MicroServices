package com.sundeep.customerDataReacter;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sundeep.customerDataReacter.model.Car;

@Component
public class CustomerDataChangeSubscriber {

	private Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private CarRepository carRepository;

	public void receiveMessage(String message) {
		logger.debug("Message: " + message);
		Iterable<Car> cars = carRepository.findCarsByCustomerId(Integer.valueOf(message.split(":")[1].trim()));
		for (Car car : cars) {
			logger.debug("Car Reg No: " + car.getCarRegNo());
			car.setCustomerId(0);
		}
		carRepository.save(cars);
	}

}
