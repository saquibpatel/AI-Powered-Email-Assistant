package com.email.writer.service.impl;

import org.springframework.stereotype.Service;

import com.email.writer.helper.GeminiHelper;
import com.email.writer.http.ApiRequest;
import com.email.writer.http.HttpEngine;
import com.email.writer.pojo.EmailRequest;
import com.email.writer.service.interfaces.EmailGeneratorService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;


@Service
@Slf4j
@RequiredArgsConstructor
public class EmailGeneratorServiveImpl implements EmailGeneratorService {
		
	private final HttpEngine httpEngine;
	
	private final GeminiHelper geminiHelper;
	
	
	@Override
	public String generateEmail(EmailRequest emailRequest) {
		log.info("Generating email.. | emailRequest: {}", emailRequest);
		
		ApiRequest apiRequest = geminiHelper.prepareHttpRequest(emailRequest);
		log.info("Received api Request in EmailGeneratorServiveImpl | apiRequest: {}", apiRequest);
		
	
		String httpresponse = httpEngine.makeHttpCall(apiRequest);
		log.info("HttpResponse received in EmailGeneratorServiveImpl | httpresponse: {}", httpresponse);
		
		return null;
	}

	
		
	
	
}
