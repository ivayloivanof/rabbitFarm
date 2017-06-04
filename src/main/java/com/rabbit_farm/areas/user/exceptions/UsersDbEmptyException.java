package com.rabbit_farm.areas.user.exceptions;

import com.rabbit_farm.areas.user.errors.UserErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = UserErrors.DATABASE_IS_EMPTY)
public class UsersDbEmptyException extends UserException {
	public UsersDbEmptyException(String message) {
		super(message);
	}
}
