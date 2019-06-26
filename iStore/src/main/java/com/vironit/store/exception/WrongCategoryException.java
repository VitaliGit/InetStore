package com.vironit.store.exception;

public class WrongCategoryException extends Exception {

	private static final long serialVersionUID = 1L;

	public WrongCategoryException() {
		super("You are allowed to choose only between the following categories: tablet, phone, book, laptop"); 
	}

	public WrongCategoryException(String message, Throwable cause) {
		super("You are allowed to choose only between the following categories: tablet, phone, book, laptop", cause);
	}
}

