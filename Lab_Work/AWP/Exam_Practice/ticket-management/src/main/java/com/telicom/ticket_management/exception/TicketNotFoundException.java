package com.telicom.ticket_management.exception;

@SuppressWarnings("serial")
public class TicketNotFoundException extends RuntimeException {

	public TicketNotFoundException(Long id) {
		super("Ticket with id: "+id+" not found!");
	}
}
