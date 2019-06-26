package com.vironit.store.exception.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler
	ResponseEntity<ErrorBean> excHandle (GoodNotFoundException gnfexc) {
		ErrorBean error = new ErrorBean(gnfexc.getMessage(), HttpStatus.NOT_FOUND.value(), System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	ResponseEntity<ErrorBean> excHandle (Exception exc) {
		ErrorBean error = new ErrorBean(exc.getMessage(), HttpStatus.BAD_REQUEST.value(), System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
