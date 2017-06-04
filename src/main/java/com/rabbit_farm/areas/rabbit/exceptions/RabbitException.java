package com.rabbit_farm.areas.rabbit.exceptions;

public abstract class RabbitException extends RuntimeException {
	public RabbitException(String message) {
		super(message);
	}
}
