package com.email.writer.http;



import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

import lombok.Data;

@Data
public class ApiRequest {

	private HttpMethod httpMethod;
	private String url;
	private HttpHeaders headers;
	private Object body;
	
}
