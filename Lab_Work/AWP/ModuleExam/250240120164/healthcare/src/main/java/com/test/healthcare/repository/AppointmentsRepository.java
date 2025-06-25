package com.test.healthcare.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.healthcare.entity.Appointment;

@Repository
public interface AppointmentsRepository extends JpaRepository<Appointment, Long> {

	List<Appointment> findAppointmentsByPatientId(String patientId);

	List<Appointment> findAllByDoctorNameAndAppointmentDateTime(String doctorName,
			LocalDateTime appointmentDateTimeParsed);

	boolean existsByPatientId(String patientId);
	
}
