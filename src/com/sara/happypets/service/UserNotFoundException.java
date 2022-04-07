package com.sara.happypets.service;

public class UserNotFoundException extends ServiceException {

	public UserNotFoundException(String message) {
		super(message);
	}
}
