package com.cdac.acts.exam.hospital.problem;

import java.time.LocalDate;

public class OutPatient extends Patient {
    public OutPatient(Integer patientId, String name, Integer age, LocalDate admissionDate, String department) {
        super(patientId, name, age, admissionDate, department, PatientType.OUT_PATIENT);
    }

    @Override
    public double calculateBill(int days) {
        return 500;  // Flat consultation fee
    }
}
