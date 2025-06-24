package com.telicom.ticket_management.entity;

import java.time.LocalDateTime;

import com.telicom.ticket_management.enums.Category;
import com.telicom.ticket_management.enums.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false, unique=true)
	private int requesterRegisteredNumber;
	
	@Enumerated(EnumType.STRING)
	private Category category;
	
	@Column(nullable=false)
	private String issuerDetails;
	
	private String resolutionDetails;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	private LocalDateTime createDateTime;
	
	private LocalDateTime resolutionDateTime;	
}
