package com.sundeep.carServiceBooking;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sundeep.carServiceBooking.helpers.CustomerServiceClient;
import com.sundeep.carServiceBooking.model.Car;
import com.sundeep.carServiceBooking.model.Customer;

@Controller
public class CarController {

	@Autowired
	private CarRepository carRepository;

	@Autowired
	private CustomerServiceClient customerServiceClient;
	
	@RequestMapping("/getCarList")
	public ModelAndView getCarList(ModelAndView modelAndView) {
		Iterable<Car> cars = carRepository.findAll();
		List<Customer> customers = customerServiceClient.getAllCustomers();
		Map<Integer, Customer> customerMap = new HashMap<>();
		customers.forEach(customer -> customerMap.put(customer.getId(), customer));
		modelAndView.addObject("carList", cars);
		modelAndView.addObject("customerMap", customerMap);
		modelAndView.setViewName("index");
		return modelAndView;
	}

	@RequestMapping("/addCarForm")
	public ModelAndView addCarForm(ModelAndView modelAndView) {
		List<Customer> customers = customerServiceClient.getAllCustomers();
		Collections.sort(customers, (a, b) -> {return a.getName().compareTo(b.getName());});
		modelAndView.addObject("customers", customers);
		modelAndView.setViewName("addCarForm");
		return modelAndView;
	}

	@RequestMapping("/addCar")
	public ModelAndView addCar(@ModelAttribute Car car, ModelAndView modelAndView) {
		carRepository.save(car);
		return getCarList(modelAndView);
	}

	@RequestMapping("/deleteCar")
	public ModelAndView deleteCar(@RequestParam Integer id, ModelAndView modelAndView) {
		carRepository.delete(id);
		return getCarList(modelAndView);
	}

	@RequestMapping("/*")
	public ModelAndView defaultView(ModelAndView modelAndView) {
		return getCarList(modelAndView);
	}

}
