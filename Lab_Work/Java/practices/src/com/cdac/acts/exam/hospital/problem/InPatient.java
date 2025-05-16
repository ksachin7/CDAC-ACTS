package com.cdac.acts.exam.hospital.problem;

import java.time.LocalDate;

public class InPatient extends Patient {
    public InPatient(Integer patientId, String name, Integer age, LocalDate admissionDate, String department) {
        super(patientId, name, age, admissionDate, department, PatientType.IN_PATIENT);
    }

    @Override
    public double calculateBill(int days) {
        return days * 2000;  // For example, ₹2000 per day
    }
}
