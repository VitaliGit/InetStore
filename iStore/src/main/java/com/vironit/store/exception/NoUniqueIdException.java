package com.vironit.store.exception;

public class NoUniqueIdException extends Exception {

	private static final long serialVersionUID = 1L;

	public NoUniqueIdException() {
		super("The same ID already exists");
	}

	public NoUniqueIdException(String message, Throwable cause) {
	
		super("The same ID already exists", cause);
	}
}
