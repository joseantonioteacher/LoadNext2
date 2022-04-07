package com.sara.happypets.service;

import com.sara.happypets.HappyPetsException;

public class ServiceException extends HappyPetsException {
	
	
	public ServiceException() {
		
	}
			
	public ServiceException(String message) {
		super(message);
	}
	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}
}
