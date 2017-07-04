package com.mx.jpenar.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

import com.mx.jpenar.businessobject.ExceptionObject;
import com.mx.jpenar.businessobject.ResponseObject;

public class BadRequestException extends HttpStatusCodeException {

	private static final long serialVersionUID = 1L;

	private final transient ExceptionObject responseObject;

	public BadRequestException(String message) {
		super(HttpStatus.BAD_REQUEST);
		responseObject = new ExceptionObject(HttpStatus.BAD_REQUEST.value(), message);
	}

	public ResponseObject getResponseObject() {
		return responseObject;
	}
}
