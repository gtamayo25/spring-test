package com.mx.jpenar.businessobject;

public class ExceptionObject extends ResponseObject {
	private Boolean isException;

	public ExceptionObject() {
		super(HTTP_STATUSCODE_INTERNALERROR, "Internal server exception");
	}

	public ExceptionObject(Integer returnCode, String message) {
		super(returnCode, message);
		isException = true;
	}

	public Boolean getIsException() {
		return isException;
	}

}
