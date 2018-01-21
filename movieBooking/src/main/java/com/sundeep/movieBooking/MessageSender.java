package com.sundeep.movieBooking;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MessageSender /*implements CommandLineRunner*/ {

//    private final RabbitTemplate rabbitTemplate;
//    private final ConfigurableApplicationContext context;
//
//    public MessageSender(RabbitTemplate rabbitTemplate,
//            ConfigurableApplicationContext context) {
//        this.rabbitTemplate = rabbitTemplate;
//        this.context = context;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        System.out.println("Sending message...");
//        int numOfMessages = 100;
//        for (int i=0; i < numOfMessages; i++) {
//        		rabbitTemplate.convertAndSend(MovieBookingApplication.queueName, String.format("Hello from RabbitMQ! for the %d time", i));
//        		Thread.sleep(1000);
//        }
//        context.close();
//    }

}