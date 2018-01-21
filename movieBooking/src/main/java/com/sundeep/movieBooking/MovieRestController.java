package com.sundeep.movieBooking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieRestController {

	@Autowired
	MovieRepository movieRepository;
	
	@RequestMapping("/getMovie")
	public Movie getMovie(@RequestParam(value="movieId", defaultValue="-1") Integer movieId) {
		return movieRepository.findOne(movieId);
	}
}
