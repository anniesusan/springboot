package com.codetest.springcodetest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.codetest.springcodetest.domain.ErrorResponse;
import com.codetest.springcodetest.exception.SpringCodeTestException;

public class BaseController {

	private final static transient Logger logger = LoggerFactory.getLogger(BaseController.class);

	@ExceptionHandler(SpringCodeTestException.class)
	public ResponseEntity<ErrorResponse> catchCodeTestException(final SpringCodeTestException exception) {
		logger.error("SpringCodeTestException exceptioncaught: " + exception.getMessage(), exception);
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
				exception.getErrorCode());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
