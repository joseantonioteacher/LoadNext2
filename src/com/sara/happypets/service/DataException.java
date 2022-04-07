package com.sara.happypets.service;

import com.sara.happypets.HappyPetsException;

public class DataException extends HappyPetsException {
	
	
	public DataException(Throwable cause) {
		super(cause);
	}
	
	
	public DataException(String message) {
		super(message);
	}
	
	public DataException(String message, Throwable cause) {
		super(message, cause);
	}
}
