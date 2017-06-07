package com.rabbit_farm.areas.rabbit.exceptions;

public abstract class RabbitException extends RuntimeException {
	
	private static final long serialVersionUID = 1638594188781921231L;

	public RabbitException(String message) {
		super(message);
	}
}
