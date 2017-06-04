package com.rabbit_farm.areas.user.exceptions;

import com.rabbit_farm.areas.user.errors.UserErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = UserErrors.NOT_FOUND_USER)
public class UserNotFoundException extends UserException {
	public UserNotFoundException(String message) {
		super(message);
	}
}
