package com.test.healthcare.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

	 @ExceptionHandler(AppointmentNotFoundException.class)
	 public ResponseEntity<String> handleAppointmentNotFound(AppointmentNotFoundException ex) {
	     return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	 }
	 
	 // generic exception handler for all other exceptions
	 @ExceptionHandler(Exception.class)
	 public ResponseEntity<String> handleGenericException(Exception ex) {
	     return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred: " + ex.getMessage());
	 }
}
