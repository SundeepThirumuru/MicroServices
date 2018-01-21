package com.sundeep.movieBooking;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class MovieValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Movie.class.equals(clazz);
	}

	@Override
	public void validate(Object movie, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "notEmpty.movie.name");
		ValidationUtils.rejectIfEmpty(errors, "release_date", "notEmpty.movie.release_date");
	}

}
