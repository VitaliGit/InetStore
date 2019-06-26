package com.vironit.store.exception.rest;

public class GoodNotFoundException extends RuntimeException {


	private static final long serialVersionUID = -8316693022602907918L;

	public GoodNotFoundException() {
	}

	public GoodNotFoundException(String message) {
		super(message);
	}

	public GoodNotFoundException(Throwable cause)  {
		super(cause);
	}

	public GoodNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public GoodNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
