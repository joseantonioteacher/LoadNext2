package com.sara.happypets.service.impl;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sara.happypets.service.*;

public class MailServiceImpl implements MailService {

	private static Logger logger = LogManager.getLogger(MailServiceImpl.class);
	
	public MailServiceImpl() {		
	}

	
	public void sendEmail(String subject, String to, String message)
			throws MailException, ServiceException {

		SimpleEmail email = new SimpleEmail();
		email.setHostName("smtp.googlemail.com");

		email.setSmtpPort(465);

		email.setAuthenticator(
				new DefaultAuthenticator("joseantoniolp.teacher@gmail.com",PASSWORD));
		email.setSSLOnConnect(true);
		try {
			email.setFrom("joseantoniolp.teacher@gmail.com");			
			email.setSubject(subject);
			email.setMsg(message);
			email.addTo(to);
			email.send();
		} catch (EmailException e) {
			logger.error(to, e);
			throw new MailException(to+": "+subject+": "+message, e);
		}
	}
	public static final String PASSWORD  = "";
}








