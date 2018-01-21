package com.sundeep.movieBooking;

import java.io.File;
import java.io.IOException;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;


@SpringBootApplication
public class MovieBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieBookingApplication.class, args);
	}
	
	@Bean
	public MessageSource messageSource() {
	     ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
	     messageSource.setBasename("classpath:messages");
	     return messageSource;
	}
	

//	@Bean
//	public EmbeddedServletContainerFactory servletContainer() {
//		TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
//		tomcat.addAdditionalTomcatConnectors(createSslConnector());
//		return tomcat;
//	}
//	
//	private Connector createSslConnector() {
//	    Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
//	    Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
//	    try {
//	        File keystore = new ClassPathResource("movies.jks").getFile();
//	        File truststore = new ClassPathResource("movies.jks").getFile();
//	        connector.setScheme("https");
//	        connector.setSecure(true);
//	        connector.setPort(8443);
//	        protocol.setSSLEnabled(true);
//	        protocol.setKeystoreFile(keystore.getAbsolutePath());
//	        protocol.setKeystorePass("movies");
//	        protocol.setTruststoreFile(truststore.getAbsolutePath());
//	        protocol.setTruststorePass("movies");
//	        protocol.setKeyAlias("tomcat");
//	        return connector;
//	    }
//	    catch (IOException ex) {
//	        throw new IllegalStateException("can't access keystore: [" + "keystore"
//	                + "] or truststore: [" + "keystore" + "]", ex);
//	    }
//	}	
//	
//	
////	@Bean
////	public EmbeddedServletContainerCustomizer tomcatCustomizer() {
////	    return (container) -> {
////	        if (container instanceof TomcatEmbeddedServletContainerFactory) {
////	            ((TomcatEmbeddedServletContainerFactory) container)
////	                    .addConnectorCustomizers((connector) -> {
////	                connector.addUpgradeProtocol(new Http2Protocol());
////	            });
////	        }
////	    };
////	}
//	
//    final static String queueName = "spring-boot";
//
//    @Bean
//    Queue queue() {
//        return new Queue(queueName, false);
//    }
//
//    @Bean
//    TopicExchange exchange() {
//        return new TopicExchange("spring-boot-exchange");
//    }
//
//    @Bean
//    Binding binding(Queue queue, TopicExchange exchange) {
//        return BindingBuilder.bind(queue).to(exchange).with(queueName);
//    }
//
//    @Bean
//    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
//            MessageListenerAdapter listenerAdapter) {
//        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//        container.setConnectionFactory(connectionFactory);
//        container.setQueueNames(queueName);
//        container.setMessageListener(listenerAdapter);
//        return container;
//    }
//
//    @Bean
//    MessageListenerAdapter listenerAdapter(MessageReceiver messageReceiver) {
//        return new MessageListenerAdapter(messageReceiver, "receiveMessage");
//    }	
	
}
