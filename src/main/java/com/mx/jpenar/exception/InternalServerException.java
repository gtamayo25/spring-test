package com.mx.jpenar.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

import com.mx.jpenar.businessobject.ExceptionObject;
import com.mx.jpenar.businessobject.ResponseObject;

public class InternalServerException extends HttpStatusCodeException {

	private static final long serialVersionUID = 1L;

	private final transient ExceptionObject responseObject;

	public InternalServerException(String message) {
		super(HttpStatus.INTERNAL_SERVER_ERROR);
		responseObject = new ExceptionObject(HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
	}

	public ResponseObject getResponseObject() {
		return responseObject;
	}
}
