package com.rabbit_farm.areas.user.exceptions;

public abstract class UserException extends RuntimeException {
	public UserException(String message) {
		super(message);
	}
}
