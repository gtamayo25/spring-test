package com.mx.jpenar.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

import com.mx.jpenar.businessobject.ExceptionObject;
import com.mx.jpenar.businessobject.ResponseObject;

public class ConflictException extends HttpStatusCodeException {

	private static final long serialVersionUID = 1L;

	private final transient ExceptionObject responseObject;

	public ConflictException(String message) {
		super(HttpStatus.CONFLICT);
		responseObject = new ExceptionObject(HttpStatus.CONFLICT.value(), message);
	}

	public ResponseObject getResponseObject() {
		return responseObject;
	}
}
