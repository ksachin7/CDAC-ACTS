package com.hospital.management.hospital_management.exception;

@SuppressWarnings("serial")
public class DoctorNotFoundException extends RuntimeException {
	public DoctorNotFoundException(String msg) {
		super(msg);
	}

}
