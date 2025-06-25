package com.test.healthcare.service;

import com.test.healthcare.entity.Appointment;
import com.test.healthcare.enums.Status;
import com.test.healthcare.exception.AppointmentNotFoundException;
import com.test.healthcare.repository.AppointmentsRepository;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentsRepository appointmentsRepo;

	@Override
	public void scheduleAppointment(String patientId, String patientName, String doctorName,
			String appointmentDateTime) {
		// Parse the appointmentDateTime string into LocalDateTime
		LocalDateTime appointmentDateTimeParsed;
		try {
			appointmentDateTimeParsed = LocalDateTime.parse(appointmentDateTime);
		} catch (Exception e) {
			throw new IllegalArgumentException(
					"Invalid appointment date/time format. Expected format: yyyy-MM-dd'T'HH:mm:ss");
		}

		// Check for conflicting appointments for the same doctor at the same time
		List<Appointment> existingAppointments = appointmentsRepo.findAllByDoctorNameAndAppointmentDateTime(doctorName,
				appointmentDateTimeParsed);

		if (!existingAppointments.isEmpty()) {
			throw new IllegalArgumentException(
					"An appointment already exists for this doctor at the specified date/time");
		}

		// Create and save the new appointment
		Appointment newAppointment = new Appointment(null, patientId, patientName, doctorName,
				appointmentDateTimeParsed, Status.SCHEDULED);
		appointmentsRepo.save(newAppointment);

		System.out.println("Scheduling appointment for " + patientName + " with Dr. " + doctorName + " on "
				+ appointmentDateTimeParsed);
	}

	@Override
	public void cancelAppointment(Long appointmentId) {
		if (appointmentId == null || !appointmentsRepo.existsById(appointmentId)) {
			throw new AppointmentNotFoundException("Appointment with ID " + appointmentId + " does not exist");
		}

		// Delete the appointment by ID
		appointmentsRepo.deleteById(appointmentId);
		System.out.println("Cancelling appointment with ID: " + appointmentId);
	}

	@Override
	public List<Appointment> getUpcomingAppointments(String patientId) {
		if (patientId == null || !appointmentsRepo.existsByPatientId(patientId)) {
			throw new AppointmentNotFoundException("Patient with ID " + patientId + " does not exist");
		}

		// Retrieve upcoming appointments for the given patient
		List<Appointment> appointments = appointmentsRepo.findAppointmentsByPatientId(patientId);

		if (appointments.isEmpty()) {
			System.out.println("No upcoming appointments found for the patient with ID " + patientId);
		}

		return appointments;
	}
}
