package com.test.healthcare.controller;

import com.test.healthcare.entity.Appointment;
import com.test.healthcare.service.AppointmentServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

  @Autowired
  AppointmentServiceImpl appointmentService;

  // Create a new appointment
  @PostMapping("/schedule")
  public ResponseEntity<String> scheduleAppointment(
    @RequestBody Appointment request
  ) {
    appointmentService.scheduleAppointment(
      request.getPatientId(),
      request.getPatientName(),
      request.getDoctorName(),
      request.getAppointmentDateTime().toString()
    );
    return ResponseEntity
      .status(201)
      .body("Appointment scheduled successfully");
  }

  // Cancel an existing appointment
  @DeleteMapping("/cancel/{id}")
  public ResponseEntity<String> cancelAppointment(@PathVariable Long id) {
    appointmentService.cancelAppointment(id);
    return ResponseEntity.ok("Appointment cancelled successfully");
  }

  // Get upcoming appointments for a specific patient
  @GetMapping("/upcoming/{patientId}")
  public ResponseEntity<List<Appointment>> getUpcomingAppointments(@PathVariable String patientId) {
    List<Appointment> appointments = appointmentService.getUpcomingAppointments(patientId);
    return ResponseEntity.ok(appointments);
  }
}
