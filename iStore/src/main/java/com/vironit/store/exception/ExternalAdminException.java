package com.vironit.store.exception;

public class ExternalAdminException extends Exception {

	private static final long serialVersionUID = 1L;

	public ExternalAdminException() {
		super("Any administrator must simultaneously be an authorized user"); 
	}

	public ExternalAdminException(String message, Throwable cause) {
		super("Any administrator must simultaneously be an authorized user", cause);
	}
}

