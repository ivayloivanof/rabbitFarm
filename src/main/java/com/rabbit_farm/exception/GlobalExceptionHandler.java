package com.rabbit_farm.exception;

import com.rabbit_farm.areas.user.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler({
			UserNotFoundException.class})
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handle404(Model model, RuntimeException exception) {
		model.addAttribute("message", exception.getMessage());

		return "error/404";
	}

//	@ExceptionHandler({
//			CarNotCreateException.class,
//			ActivityNotCreateException.class,
//			CustomerNotCreateException.class,
//			ServiceNotCreateException.class})
//	@ResponseStatus(HttpStatus.CONFLICT)
//	public String handle409(Model model, CarWashErrorException exception) {
//		model.addAttribute("message", exception.getMessage());
//
//		return "error/409";
//	}
}
