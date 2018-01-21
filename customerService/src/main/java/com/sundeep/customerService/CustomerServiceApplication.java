package com.sundeep.customerService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootApplication
@EnableCaching
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
	
	@Bean
	public StringRedisTemplate getStringRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
		return new StringRedisTemplate(redisConnectionFactory);
	}
	
	@Bean
	public CustomerDataChangePublisher getCustomerDataChangeMessagePublisher(StringRedisTemplate redisTemplate) {
		return new CustomerDataChangePublisher(redisTemplate);
	}
}
