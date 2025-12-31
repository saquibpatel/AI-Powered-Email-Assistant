package com.email.writer.service.interfaces;

import com.email.writer.pojo.EmailRequest;

public interface EmailGeneratorService {

	String generateEmail(EmailRequest emailRequest);


}

