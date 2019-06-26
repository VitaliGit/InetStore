package com.vironit.store.exception;

public class IdentityException extends Exception {

	private static final long serialVersionUID = -5298022274304899496L;

	public IdentityException() {
		
		super("Your password or login is not correct");
	}
	public IdentityException(String message, Throwable cause) {
	
		super("Your password or login is not correct", cause);
	}
}
