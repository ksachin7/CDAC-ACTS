package com.test.healthcare.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.test.healthcare.enums.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "Patient ID cannot be empty")
  private String patientId;

  @NotBlank(message = "Patient name cannot be blank")
  private String patientName;

  @NotBlank(message = "Doctor name cannot be blank")
  private String doctorName;

  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") // Automatically handle date-time formatting
  private LocalDateTime appointmentDateTime;

  @Enumerated(EnumType.STRING)
  private Status status;
  //	@ManyToOne
  //	@JoinColumn(name = "doctor_id", nullable = false)
  //	private Doctor doctor;
}
