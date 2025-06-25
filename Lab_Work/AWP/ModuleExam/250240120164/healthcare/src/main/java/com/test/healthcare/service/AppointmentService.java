package com.test.healthcare.service;

import java.util.List;

import com.test.healthcare.entity.Appointment;

public interface AppointmentService {
	
	void scheduleAppointment(String patientId, String patientName, String doctorName, String appointmentDateTime);

	void cancelAppointment(Long appointmentId);

	List<Appointment> getUpcomingAppointments(String id);
}
