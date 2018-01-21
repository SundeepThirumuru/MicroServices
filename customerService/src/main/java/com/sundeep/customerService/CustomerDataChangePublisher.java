package com.sundeep.customerService;

import org.apache.log4j.Logger;
import org.springframework.data.redis.core.StringRedisTemplate;

public class CustomerDataChangePublisher {

	private StringRedisTemplate redisTemplate;
	private Logger logger = Logger.getLogger(this.getClass());

	public CustomerDataChangePublisher(StringRedisTemplate redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	public void sendDeleteCustomerMessage(int customerId) {
		logger.debug(String.format("Publish Customer %d Delete Message to %s Channel", customerId,
				Constants.REDIS_PUBLISH_CHANNEL));
		try {
			redisTemplate.convertAndSend(Constants.REDIS_PUBLISH_CHANNEL,
					String.format(Constants.REDIS_MESSAGE_FORMAT, customerId));
		} catch (Exception e) {
			logger.error("Redis Message Publish Failed");
		}
	}
}
