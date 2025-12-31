package com.email.writer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class EmailConfig {
	
	
	@Bean
	WebClient getweBClientBuilder() {
		return WebClient.builder().build();
	}
	
	
}
