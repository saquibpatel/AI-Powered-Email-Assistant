package com.email.writer.http;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Component
@Slf4j
@RequiredArgsConstructor
public class HttpEngine {
	
	private final WebClient webClient;
	
	public ResponseEntity<String> makeHttpCall(ApiRequest apiRequest) {
		
	log.info("Making httpcall...| apiRequest: {}", apiRequest);
		
		   ResponseEntity<String> response = webClient.method(apiRequest.getHttpMethod())
				 .uri(apiRequest.getUrl())
				 .headers(header -> header.addAll(apiRequest.getHeaders()))
				 .bodyValue(apiRequest.getBody())
				 .retrieve()
				 .toEntity(String.class)
				 .block();
				 
				 
	log.info("Returning http Response..| response: {}", response);
		return response;	
		
	}
	
}
