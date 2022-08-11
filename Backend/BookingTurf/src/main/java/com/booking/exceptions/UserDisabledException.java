package com.booking.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class UserDisabledException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public UserDisabledException(String message) {
		super(message);
	}
}
