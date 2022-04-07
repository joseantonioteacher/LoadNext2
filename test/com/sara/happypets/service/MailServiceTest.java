package com.sara.happypets.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sara.happypets.service.impl.MailServiceImpl;

public class MailServiceTest {
	private static Logger logger = LogManager.getLogger(MailServiceTest.class);
	
	private MailService mailService = null;
	
	public MailServiceTest () {
		mailService  = new MailServiceImpl();
	}
	
	public void testSendEmail() {		
		logger.traceEntry();
		String email = "joseantoniolp.teacher@gmail.com";
		try {			
			mailService.sendEmail("Hola", email, "Test OK");
		} catch (ServiceException se) {
			logger.error(email, se);			
		}
		logger.traceExit();
	}
	
	public static void main(String args[]) {
		MailServiceTest test = new MailServiceTest();
		test.testSendEmail();
	}
	
}
