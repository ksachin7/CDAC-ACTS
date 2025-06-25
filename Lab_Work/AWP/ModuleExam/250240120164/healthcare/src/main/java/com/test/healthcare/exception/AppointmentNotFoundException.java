package com.test.healthcare.exception;

public class AppointmentNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AppointmentNotFoundException(String message) {
		super(message);
	}

	public AppointmentNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
