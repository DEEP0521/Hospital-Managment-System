package com.jkt.training.ExceptionHandler;

public class ErrorMessage {
	private int errorCode;
	private String errorMessage;
	
	
	public ErrorMessage() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ErrorMessage(int errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}


	public int getErrorCode() {
		return errorCode;
	}


	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}


	public String getErrorMessage() {
		return errorMessage;
	}


	public void setErrorMeassage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
	

}
