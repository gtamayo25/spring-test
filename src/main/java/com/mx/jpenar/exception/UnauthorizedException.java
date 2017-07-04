package com.mx.jpenar.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

import com.mx.jpenar.businessobject.ExceptionObject;
import com.mx.jpenar.businessobject.ResponseObject;

public class UnauthorizedException extends HttpStatusCodeException {

	private static final long serialVersionUID = 1L;

	private final transient ExceptionObject responseObject;

	public UnauthorizedException(String message) {
		super(HttpStatus.UNAUTHORIZED);
		responseObject = new ExceptionObject(HttpStatus.UNAUTHORIZED.value(), message);
	}

	public ResponseObject getResponseObject() {
		return responseObject;
	}
}
