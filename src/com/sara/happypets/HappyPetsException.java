package com.sara.happypets;

public class HappyPetsException extends Exception {
	
	public HappyPetsException() {
	}
		
	public HappyPetsException(String message) {
		super(message);
	}	
	
	public HappyPetsException(Throwable cause) {
		super(cause);
	}
	
	public HappyPetsException(String message, Throwable cause) {
		super(message, cause);
	}
}
