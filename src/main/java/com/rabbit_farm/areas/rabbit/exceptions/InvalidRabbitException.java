package com.rabbit_farm.areas.rabbit.exceptions;

import com.rabbit_farm.areas.rabbit.errors.RabbitErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = RabbitErrors.INVALID_RABBIT)
public class InvalidRabbitException extends RabbitException {

	private static final long serialVersionUID = -740514638114824450L;

	public InvalidRabbitException(String message) {
		super(message);
	}
}
