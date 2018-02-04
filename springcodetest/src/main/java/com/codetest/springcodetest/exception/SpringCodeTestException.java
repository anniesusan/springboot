package com.codetest.springcodetest.exception;

public class SpringCodeTestException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private String errorMessage;
	private String errorCode;
	
	public SpringCodeTestException(String code, String message) {
		super(message);
		this.errorCode = code;
		this.errorMessage = message;
	}
	
	public SpringCodeTestException(String code, String message, Throwable cause) {
		super(message,cause);
		this.errorCode = code;
		this.errorMessage = message;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

}
