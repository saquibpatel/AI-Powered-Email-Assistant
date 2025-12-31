package com.email.writer.helper;


import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import com.email.writer.api.req.Content;
import com.email.writer.api.req.GeminiRequest;
import com.email.writer.api.req.Part;
import com.email.writer.http.ApiRequest;
import com.email.writer.pojo.EmailRequest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class GeminiHelper {

	private  String geminiApiUrl = "url";

	public ApiRequest prepareHttpRequest(EmailRequest emailRequest) {
		log.info("preparing httpRequest...| EmailRequest: {}", emailRequest);
		
		String prompt = buildPrompt(emailRequest);
		log.info("prompt created..| prompt: {}", prompt);
		
		//set header
		HttpHeaders headers = new HttpHeaders();
		headers.set("x-goog-api-key","api key");
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		//set body
		Part part = new Part();
		part.setText(prompt);
		
		Content content = new Content();
		content.setParts(List.of(part));
		
		GeminiRequest geminiRequest = new GeminiRequest();
		geminiRequest.setContents(List.of(content));
	
		//prepare http request
		ApiRequest apiRequest = new ApiRequest();
		
		apiRequest.setHttpMethod(HttpMethod.POST);
		apiRequest.setHeaders(headers);
		apiRequest.setUrl(geminiApiUrl);
		apiRequest.setBody(geminiRequest);
		
		log.info("Returning gemini ApiRequest | ApiRequest; {}", apiRequest);
		return apiRequest;
	}
		
	private String buildPrompt(EmailRequest emailRequest) {

		StringBuilder prompt = new StringBuilder();			
		prompt.append("Generate professional email reply for the following email:");
								
		if(emailRequest.getTone() != null && !emailRequest.getTone().isEmpty()) {
			prompt.append(" Use a ").append(emailRequest.getTone()).append(" tone.");
		}
		prompt.append("Original Email: \n").append(emailRequest.getEmailContent());
		
	return prompt.toString();
}
	
	
}
