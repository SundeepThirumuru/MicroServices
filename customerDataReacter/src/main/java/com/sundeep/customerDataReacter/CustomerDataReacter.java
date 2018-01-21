package com.sundeep.customerDataReacter;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class CustomerDataReacter 
{
    public static void main( String[] args )
    {
    		SpringApplication.run(CustomerDataReacter.class, args);
    		Scanner scanner = new Scanner(System.in);
    		while(!scanner.next().equals("quit")) {
    			try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
    		System.exit(0);
    }
    
	@Bean
	RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
			MessageListenerAdapter listenerAdapter) {
		RedisMessageListenerContainer container = new RedisMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.addMessageListener(listenerAdapter, new PatternTopic("DeleteCustomer"));

		return container;
	}

	@Bean
	MessageListenerAdapter listenerAdapter(CustomerDataChangeSubscriber customerDataChangeSubscriber) {
		return new MessageListenerAdapter(customerDataChangeSubscriber, "receiveMessage");
	}
}
