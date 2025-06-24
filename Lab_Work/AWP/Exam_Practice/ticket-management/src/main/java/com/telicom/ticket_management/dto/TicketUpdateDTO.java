package com.telicom.ticket_management.dto;

import java.time.LocalDateTime;

import com.telicom.ticket_management.enums.Status;

import lombok.Data;

@Data
public class TicketUpdateDTO {
	private Status status;
	private String resolutionDetails;
	private LocalDateTime resolutionDateTime;
}
