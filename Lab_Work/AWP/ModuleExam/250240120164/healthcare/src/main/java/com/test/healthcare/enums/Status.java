package com.test.healthcare.enums;

public enum Status {
	SCHEDULED("Scheduled"),
	COMPLETED("Completed"),
	CANCELLED("Cancelled");

	private final String status;

	Status(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
}
