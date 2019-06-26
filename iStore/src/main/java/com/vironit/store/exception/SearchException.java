package com.vironit.store.exception;

public class SearchException extends Exception{

	private static final long serialVersionUID = -4769548152451441245L;
	
	public SearchException() {
		super("This entity cannot be found");	}
	
	public SearchException(String message, Throwable cause) {
		super("This entity cannot be found", cause);
	}

}
