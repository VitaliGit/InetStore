package com.vironit.store.exception;

public class NoUniqueUserNameException extends Exception {

	private static final long serialVersionUID = 321910143691951771L;
	
	
	public NoUniqueUserNameException() {
		super("Your login already exists");
	}

	public NoUniqueUserNameException(String message, Throwable cause) {
	
		super("Your login already exists", cause);
	}
}
