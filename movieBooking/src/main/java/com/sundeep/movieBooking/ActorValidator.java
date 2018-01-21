package com.sundeep.movieBooking;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ActorValidator implements Validator{
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Actor.class.equals(clazz);
	}

	@Override
	public void validate(Object actor, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "notEmpty.actor.firstName");
	}
	

}
