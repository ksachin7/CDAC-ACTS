package com.hospital.management.hospital_management.service;

import java.util.List;
import java.util.Optional;

import com.hospital.management.hospital_management.entity.Appointment;

public interface AppointmentService {
	Appointment createAppointment(Appointment appointment);
	Appointment updateAppointment(int id, Appointment appointment);
	void deleteAppointment(int id);
	Optional<Appointment> findAppointmentById(int id);
	List<Appointment> findAppointmentsByDoctor(int doctorId);
	List<Appointment> findAllAppointments();
}
