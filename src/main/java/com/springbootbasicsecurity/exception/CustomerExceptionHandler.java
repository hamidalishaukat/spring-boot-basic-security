package com.springbootbasicsecurity.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomerExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(ItemNotFoundException.class)
	public ResponseEntity<Object> handleException(ItemNotFoundException exc, WebRequest req) {
		ExceptionResponse res = new ExceptionResponse();
		res.setMessage("Itemm Not Found, we dont store lenght is more than 10");
		res.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(res,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(InvalidUserException.class)
	public ResponseEntity<Object> handleException(InvalidUserException exc, WebRequest req) {
		ExceptionResponse res = new ExceptionResponse();
		res.setMessage("Itemm Details entered is incorrect");
		res.setStatusCode(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(res,HttpStatus.BAD_REQUEST);
		
	}
}
