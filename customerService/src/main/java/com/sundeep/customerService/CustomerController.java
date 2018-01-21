package com.sundeep.customerService;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sundeep.customerService.model.Customer;

@Controller
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerDataChangePublisher customerDataChangePublisher;
	
	@RequestMapping("/getCustomerList")
	public ModelAndView getCarList(ModelAndView modelAndView) {
		modelAndView.addObject("customerList", customerRepository.findAll());
		modelAndView.setViewName("index");
		return modelAndView;
	}
	
	@RequestMapping("/addCustomerForm")
	public ModelAndView addCarForm(ModelAndView modelAndView) {
		modelAndView.setViewName("addCustomerForm");
		return modelAndView;
	}
	
	@RequestMapping("/addCustomer")
	public ModelAndView addCar(@ModelAttribute Customer customer, ModelAndView modelAndView, HttpSession session) {
		customerRepository.save(customer);
		return getCarList(modelAndView);
	}
	
	@RequestMapping("/deleteCustomer")
	public ModelAndView deleteCar(@RequestParam Integer id, ModelAndView modelAndView) {
		customerRepository.delete(id);
		customerDataChangePublisher.sendDeleteCustomerMessage(id);
		return getCarList(modelAndView);
	}
	
	@RequestMapping("/*")
	public ModelAndView defaultView(ModelAndView modelAndView) {
		return getCarList(modelAndView);
	}
	

}
