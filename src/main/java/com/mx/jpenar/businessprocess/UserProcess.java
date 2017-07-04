package com.mx.jpenar.businessprocess;

import org.apache.ibatis.javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mx.jpenar.businessobject.UserCreatedOutput;
import com.mx.jpenar.businessobject.UserInputObject;
import com.mx.jpenar.exception.BadRequestException;
import com.mx.jpenar.exception.UnauthorizedException;

@Service
public class UserProcess {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserProcess.class);

	public void validateToken(String token) {
		if (!"jpenarTest".equals(token)) {
			throw new UnauthorizedException("token is not valid");
		}
	}

	private void validateUser(UserInputObject user) {
		if (user.getName() == null || user.getName().trim().isEmpty()) {
			throw new BadRequestException("name is required");
		}
	}

	public UserCreatedOutput addUser(UserInputObject user) throws NotFoundException {
		LOGGER.info("CommentProcess addEntitlementComment: entitlementId");
		validateUser(user);
		UserCreatedOutput newUser = new UserCreatedOutput();

		return newUser;
	}

	public UserCreatedOutput updateUser(UserInputObject user, String userId) throws NotFoundException {
		LOGGER.info("CommentProcess addEntitlementComment: entitlementId");
		validateUser(user);
		UserCreatedOutput newUser = new UserCreatedOutput();

		return newUser;
	}

	public UserCreatedOutput deleteUser(String id) throws NotFoundException {
		LOGGER.info("CommentProcess addEntitlementComment: entitlementId");
		UserCreatedOutput newUser = new UserCreatedOutput();

		return newUser;
	}

	public UserCreatedOutput getUser(String id) throws NotFoundException {
		LOGGER.info("CommentProcess addEntitlementComment: entitlementId");
		UserCreatedOutput newUser = new UserCreatedOutput();

		return newUser;
	}

	public UserCreatedOutput getUsers() throws NotFoundException {
		LOGGER.info("CommentProcess addEntitlementComment: entitlementId");
		UserCreatedOutput newUser = new UserCreatedOutput();

		return newUser;
	}
}
