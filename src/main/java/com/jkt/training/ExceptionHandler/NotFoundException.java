package com.jkt.training.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class NotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Object> AllException(Exception e,WebRequest wb){
		InternalServer server=new InternalServer(e.getMessage(),wb.getDescription(false));
		return new ResponseEntity<>(server.message,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = RecordNotFoundException.class)
	public ResponseEntity<Object> PatientException(RecordNotFoundException rec){
		return new ResponseEntity<>("Not Found!!",HttpStatus.NOT_FOUND);
	}

}
