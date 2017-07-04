package com.mx.jpenar.businessobject;

public class UserCreatedOutput extends ResponseObject {

	public static final String MESSAGE_OK = "User created";

	public UserCreatedOutput() {
		super(HTTP_STATUSCODE_CREATED, MESSAGE_OK);
	}

}
