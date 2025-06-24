package com.hospital.management.hospital_management.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hospital.management.hospital_management.entity.Appointment;
import com.hospital.management.hospital_management.exception.AppointmentException;
import com.hospital.management.hospital_management.service.AppointmentService;

@Controller
@RequestMapping("/appointment")
public class AppointmentController {

	@Autowired
	AppointmentService service;

	@PostMapping
	public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appointment) {
		return ResponseEntity.status(201).body(service.createAppointment(appointment));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Appointment> updateAppointment(@PathVariable int id, @RequestBody Appointment appointment) {
		return ResponseEntity.ok(service.updateAppointment(id, appointment));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Appointment> deleteAppointment(@PathVariable int id) {
		service.deleteAppointment(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Appointment> getAppointmentById(@PathVariable int id) {
		Optional<Appointment> appointment= service.findAppointmentById(id);
		return appointment.map(ResponseEntity::ok).orElseThrow(()-> new AppointmentException("Appointment with id: "+id+" is not found!"));
	}
	
	@GetMapping("/doctor/{doctorId}")
	public ResponseEntity<List<Appointment>> getAppointmentByDoctor(@PathVariable int doctorId) {
		return ResponseEntity.ok(service.findAppointmentsByDoctor(doctorId));
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Appointment>> getAllAppointments() {
		return ResponseEntity.ok(service.findAllAppointments());
	}
}
