package com.email.writer.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.email.writer.pojo.EmailRequest;
import com.email.writer.service.interfaces.EmailGeneratorService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/email")
@RequiredArgsConstructor
public class EmailGeneratorController {

	
	private final EmailGeneratorService emailGeneratorService;
	
	
	@PostMapping("/generate")
	public String gererateEmail(@RequestBody EmailRequest emailRequest){
		
		String response = emailGeneratorService.generateEmail( emailRequest);
		return response;
	}
	
}
