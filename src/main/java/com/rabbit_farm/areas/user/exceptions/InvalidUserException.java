package com.rabbit_farm.areas.user.exceptions;

import com.rabbit_farm.areas.user.errors.UserErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = UserErrors.INVALID_USER)
public class InvalidUserException extends UserException {
	public InvalidUserException(String message) {
		super(message);
	}
}
