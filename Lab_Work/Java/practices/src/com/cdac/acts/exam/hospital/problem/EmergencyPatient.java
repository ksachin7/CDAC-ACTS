package com.cdac.acts.exam.hospital.problem;

import java.time.LocalDate;

public class EmergencyPatient extends Patient {
    public EmergencyPatient(Integer patientId, String name, Integer age, LocalDate admissionDate, String department) {
        super(patientId, name, age, admissionDate, department, PatientType.EMERGENCY);
    }

    @Override
    public double calculateBill(int days) {
        return 3000 + (days * 2500);  // Emergency charge + daily charge
    }
}
