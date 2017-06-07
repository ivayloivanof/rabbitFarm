package com.rabbit_farm.areas.rabbit.exceptions;

import com.rabbit_farm.areas.rabbit.errors.RabbitErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = RabbitErrors.NOT_FOUND)
public class RabbitNotFoundException extends RabbitException {
	
	private static final long serialVersionUID = -6494150331699746391L;

	public RabbitNotFoundException(String message) {
		super(message);
	}
}
