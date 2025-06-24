package com.hospital.management.hospital_management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.management.hospital_management.entity.Appointment;
import com.hospital.management.hospital_management.exception.AppointmentException;
import com.hospital.management.hospital_management.repository.AppointmentRepository;

@Service
public class AppointmentServiceImpl implements AppointmentService {
	
	@Autowired
	private AppointmentRepository appointmentRepo;
	

	@Override
	public Appointment createAppointment(Appointment appointment) {
		return appointmentRepo.save(appointment);
	}

	@Override
	public Appointment updateAppointment(int id, Appointment appointment) {
		Appointment existingAppointment= appointmentRepo.findById(id).orElseThrow(()-> new AppointmentException("Appointment not found!"));
	    
	    existingAppointment.setPatientName(appointment.getPatientName());
	    existingAppointment.setAppointmentDate(appointment.getAppointmentDate());
//	    existingAppointment.setDoctorId(appointment.getDoctorId());
	    existingAppointment.setDoctor(appointment.getDoctor());

		return appointmentRepo.save(existingAppointment);
	}

	@Override
	public void deleteAppointment(int id) {
		Appointment appointment= appointmentRepo.findById(id).orElseThrow(()-> new AppointmentException("Appointment not found!"));
		appointmentRepo.delete(appointment);
	}

	@Override
	public Optional<Appointment> findAppointmentById(int id) {
		return appointmentRepo.findById(id);
	}

	@Override
	public List<Appointment> findAppointmentsByDoctor(int doctorId) {
		return appointmentRepo.findByDoctorId(doctorId);
	}

	@Override
	public List<Appointment> findAllAppointments() {
		return appointmentRepo.findAll();
	}

}
