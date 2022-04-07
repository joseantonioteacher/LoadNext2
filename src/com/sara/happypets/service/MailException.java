package com.sara.happypets.service;

public class MailException extends ServiceException {

	public MailException(String message) {
		super(message);
	}
	
	public MailException(String message, Throwable t) {
		super(message, t);
	}
}
