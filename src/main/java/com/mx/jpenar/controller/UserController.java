package com.mx.jpenar.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mx.jpenar.businessobject.ExceptionObject;
import com.mx.jpenar.businessobject.ResponseObject;
import com.mx.jpenar.businessobject.UserCreatedOutput;
import com.mx.jpenar.businessobject.UserInputObject;
import com.mx.jpenar.businessprocess.UserProcess;
import com.mx.jpenar.exception.BadRequestException;
import com.mx.jpenar.exception.ConflictException;
import com.mx.jpenar.exception.InternalServerException;
import com.mx.jpenar.exception.UnauthorizedException;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserProcess userProcess;

	@ApiOperation(value = "addUser", nickname = "addUser", response = ResponseObject.class)
	@ApiResponses({ @ApiResponse(code = 201, message = UserCreatedOutput.MESSAGE_OK, response = ResponseObject.class),
			@ApiResponse(code = 400, message = "Invalid input", response = ExceptionObject.class),
			@ApiResponse(code = 409, message = "userID duplicated", response = ExceptionObject.class),
			@ApiResponse(code = 500, message = "Internal server error", response = ExceptionObject.class), })
	@RequestMapping(value = "/v1/user/", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<ResponseObject> addUser(@RequestHeader("x-jpenar-token") String token,
			@RequestBody UserInputObject input) {
		LOGGER.info("CommentController importInvoice");
		ResponseEntity<ResponseObject> response;
		try {
			userProcess.validateToken(token);
			ResponseObject newUSer = userProcess.addUser(input);
			response = new ResponseEntity<>(newUSer, HttpStatus.CREATED);
		} catch (BadRequestException e) {
			response = new ResponseEntity<>(e.getResponseObject(), HttpStatus.BAD_REQUEST);
		} catch (ConflictException e) {
			response = new ResponseEntity<>(e.getResponseObject(), HttpStatus.CONFLICT);
		} catch (UnauthorizedException e) {
			response = new ResponseEntity<>(e.getResponseObject(), HttpStatus.UNAUTHORIZED);
		} catch (InternalServerException e) {
			response = new ResponseEntity<>(e.getResponseObject(), HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			LOGGER.error("CommentController importInvoice", e);
			ResponseObject responseObject = new ExceptionObject(500, "Internal Error Server");
			response = new ResponseEntity<>(responseObject, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

	@ApiOperation(value = "updateUser", nickname = "updateUser", response = ResponseObject.class)
	@ApiResponses({ @ApiResponse(code = 201, message = UserCreatedOutput.MESSAGE_OK, response = ResponseObject.class),
			@ApiResponse(code = 400, message = "Invalid input", response = ExceptionObject.class),
			@ApiResponse(code = 404, message = "Not found", response = ExceptionObject.class),
			@ApiResponse(code = 500, message = "Internal server error", response = ExceptionObject.class), })
	@RequestMapping(value = "/v1/user/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<ResponseObject> updateUser(@RequestHeader("x-jpenar-token") String token,
			@RequestBody UserInputObject input, @PathVariable(value = "id") String userId) {
		LOGGER.info("CommentController importInvoice");
		ResponseEntity<ResponseObject> response;
		try {
			userProcess.validateToken(token);
			ResponseObject newUSer = userProcess.updateUser(input, userId);
			response = new ResponseEntity<>(newUSer, HttpStatus.OK);
		} catch (BadRequestException e) {
			response = new ResponseEntity<>(e.getResponseObject(), HttpStatus.BAD_REQUEST);
		} catch (ConflictException e) {
			response = new ResponseEntity<>(e.getResponseObject(), HttpStatus.CONFLICT);
		} catch (UnauthorizedException e) {
			response = new ResponseEntity<>(e.getResponseObject(), HttpStatus.UNAUTHORIZED);
		} catch (InternalServerException e) {
			response = new ResponseEntity<>(e.getResponseObject(), HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			LOGGER.error("CommentController importInvoice", e);
			ResponseObject responseObject = new ExceptionObject(500, "Internal Error Server");
			response = new ResponseEntity<>(responseObject, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

	@ApiOperation(value = "getUsers", nickname = "getUsers", response = ResponseObject.class)
	@ApiResponses({ @ApiResponse(code = 201, message = UserCreatedOutput.MESSAGE_OK, response = ResponseObject.class),
			@ApiResponse(code = 400, message = "Invalid input", response = ExceptionObject.class),
			@ApiResponse(code = 404, message = "Not found", response = ExceptionObject.class),
			@ApiResponse(code = 500, message = "Internal server error", response = ExceptionObject.class), })
	@RequestMapping(value = "/v1/user/", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseObject> getUsers(@RequestHeader("x-jpenar-token") String token) {
		LOGGER.info("COMController getCOLEInfo");
		ResponseEntity<ResponseObject> response;
		try {
			userProcess.validateToken(token);
			ResponseObject newUSer = userProcess.getUsers();
			response = new ResponseEntity<>(newUSer, HttpStatus.OK);

		} catch (BadRequestException e) {
			response = new ResponseEntity<>(e.getResponseObject(), HttpStatus.BAD_REQUEST);
		} catch (ConflictException e) {
			response = new ResponseEntity<>(e.getResponseObject(), HttpStatus.CONFLICT);
		} catch (UnauthorizedException e) {
			response = new ResponseEntity<>(e.getResponseObject(), HttpStatus.UNAUTHORIZED);
		} catch (InternalServerException e) {
			response = new ResponseEntity<>(e.getResponseObject(), HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			LOGGER.error("CommentController importInvoice", e);
			ResponseObject responseObject = new ExceptionObject(500, "Internal Error Server");
			response = new ResponseEntity<>(responseObject, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

	@ApiOperation(value = "getUser", nickname = "getUser", response = ResponseObject.class)
	@ApiResponses({ @ApiResponse(code = 201, message = UserCreatedOutput.MESSAGE_OK, response = ResponseObject.class),
			@ApiResponse(code = 400, message = "Invalid input", response = ExceptionObject.class),
			@ApiResponse(code = 404, message = "Not found", response = ExceptionObject.class),
			@ApiResponse(code = 500, message = "Internal server error", response = ExceptionObject.class), })
	@RequestMapping(value = "/v1/user/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseObject> getUser(@RequestHeader("x-jpenar-token") String token,
			@PathVariable(value = "id") String userId) {
		LOGGER.info("COMController getCOLEInfo");
		ResponseEntity<ResponseObject> response;
		try {
			userProcess.validateToken(token);
			ResponseObject newUSer = userProcess.getUser(userId);
			response = new ResponseEntity<>(newUSer, HttpStatus.OK);

		} catch (BadRequestException e) {
			response = new ResponseEntity<>(e.getResponseObject(), HttpStatus.BAD_REQUEST);
		} catch (ConflictException e) {
			response = new ResponseEntity<>(e.getResponseObject(), HttpStatus.CONFLICT);
		} catch (UnauthorizedException e) {
			response = new ResponseEntity<>(e.getResponseObject(), HttpStatus.UNAUTHORIZED);
		} catch (InternalServerException e) {
			response = new ResponseEntity<>(e.getResponseObject(), HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			LOGGER.error("CommentController importInvoice", e);
			ResponseObject responseObject = new ExceptionObject(500, "Internal Error Server");
			response = new ResponseEntity<>(responseObject, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

	@ApiOperation(value = "deleteUser", nickname = "deleteUser", response = ResponseObject.class)
	@ApiResponses({ @ApiResponse(code = 201, message = UserCreatedOutput.MESSAGE_OK, response = ResponseObject.class),
			@ApiResponse(code = 400, message = "Invalid input", response = ExceptionObject.class),
			@ApiResponse(code = 404, message = "Not found", response = ExceptionObject.class),
			@ApiResponse(code = 500, message = "Internal server error", response = ExceptionObject.class), })
	@RequestMapping(value = "/v1/user/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<ResponseObject> deleteUser(@RequestHeader("x-jpenar-token") String token,
			@PathVariable(value = "id") String userId) {
		LOGGER.info("COMController getCOLEInfo");
		ResponseEntity<ResponseObject> response;
		try {
			userProcess.validateToken(token);
			ResponseObject newUSer = userProcess.deleteUser(userId);
			response = new ResponseEntity<>(newUSer, HttpStatus.OK);

		} catch (BadRequestException e) {
			response = new ResponseEntity<>(e.getResponseObject(), HttpStatus.BAD_REQUEST);
		} catch (ConflictException e) {
			response = new ResponseEntity<>(e.getResponseObject(), HttpStatus.CONFLICT);
		} catch (UnauthorizedException e) {
			response = new ResponseEntity<>(e.getResponseObject(), HttpStatus.UNAUTHORIZED);
		} catch (InternalServerException e) {
			response = new ResponseEntity<>(e.getResponseObject(), HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			LOGGER.error("CommentController importInvoice", e);
			ResponseObject responseObject = new ExceptionObject(500, "Internal Error Server");
			response = new ResponseEntity<>(responseObject, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

}
