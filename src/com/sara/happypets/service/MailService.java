package com.sara.happypets.service;

public interface MailService {

	
	public void sendEmail(String subject, String to, String message)
		throws MailException, ServiceException;
		
	
}
