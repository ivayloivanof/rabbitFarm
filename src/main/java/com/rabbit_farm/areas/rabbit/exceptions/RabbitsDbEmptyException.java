package com.rabbit_farm.areas.rabbit.exceptions;

import com.rabbit_farm.areas.rabbit.errors.RabbitErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = RabbitErrors.EMPTY_DATABASE)
public class RabbitsDbEmptyException extends RabbitException {
	
	private static final long serialVersionUID = 4312336608158186268L;

	public RabbitsDbEmptyException(String message) {
		super(message);
	}
}
