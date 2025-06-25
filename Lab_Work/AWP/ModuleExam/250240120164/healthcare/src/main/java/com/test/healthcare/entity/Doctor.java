//package com.test.healthcare.entity;
//
//import java.util.List;
//
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;
//import jakarta.validation.constraints.NotBlank;
//import lombok.Data;
//
//@Entity
//@Data
//public class Doctor {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//
//	@NotBlank(message = "Doctor name cannot be blank")
//	private String name;
//	private String specialty;
//	private String contactNumber;
//	
//	@OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
//	private List<Appointment> appointments;
//}
