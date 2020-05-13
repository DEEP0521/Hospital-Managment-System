package com.jkt.training.advice;


import java.io.PrintWriter;
import java.io.StringWriter;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.http.HttpStatus;

import com.jkt.training.ExceptionHandler.ErrorMessage;


@Provider
public class ServiceExceptionMapper implements ExceptionMapper<ServiceException> {

	@Override
	public Response toResponse(ServiceException ex)
	{
		ErrorMessage error=new ErrorMessage();
		error.setErrorMeassage(ex.getMessage());
		error.setErrorCode(ex.getStatusCode());
		StringWriter writer =new StringWriter();
		ex.printStackTrace(new PrintWriter(writer));
		return Response.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).entity(error).type(MediaType.APPLICATION_JSON).build();
	}

	

	
	}

	
