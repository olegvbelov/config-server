package com.beloll.configserver.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

	@Value("${spring.rabbitmq.hostname}")
	private String hostname;

	@Value("${spring.rabbitmq.username}")
	private String username;

	@Value("${spring.rabbitmq.password}")
	private String password;

	@Value("${spring.rabbitmq.vhost}")
	private String vhost;

	@Bean
	ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory(hostname);
		connectionFactory.setUsername(username);
		connectionFactory.setPassword(password);
		connectionFactory.setVirtualHost(vhost);

		//Recommended settings
		connectionFactory.setRequestedHeartBeat(30);
		connectionFactory.setConnectionTimeout(30000);

		return connectionFactory;
	}

	public AmqpTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		return rabbitTemplate;
	}

}
