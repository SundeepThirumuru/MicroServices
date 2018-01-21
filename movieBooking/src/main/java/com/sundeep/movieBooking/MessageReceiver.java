package com.sundeep.movieBooking;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {
	
	public void receiveMessage(String message) {

		System.out.println(String.format("Incoming message at time %s: %s", 
				SimpleDateFormat.getInstance().format(Calendar.getInstance().getTime()),
				message));
	}
	

}
