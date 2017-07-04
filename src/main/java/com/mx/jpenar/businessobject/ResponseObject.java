package com.mx.jpenar.businessobject;

public class ResponseObject {

	public static final int HTTP_STATUSCODE_OK = 200;
	public static final int HTTP_STATUSCODE_CREATED = 201;
	public static final int HTTP_STATUSCODE_BADREQUEST = 400;
	public static final int HTTP_STATUSCODE_FORBIDDEN = 403;
	public static final int HTTP_STATUSCODE_NOTFOUND = 404;
	public static final int HTTP_STATUSCODE_CONFLICT = 409;
	public static final int HTTP_STATUSCODE_INTERNALERROR = 500;

	private Integer returnCode;
	private String message;

	protected ResponseObject(Integer returnCode, String message) {
		this.returnCode = returnCode;
		this.message = message;
	}

	public Integer getReturnCode() {
		return returnCode;
	}

	public String getMessage() {
		return message;
	}

}