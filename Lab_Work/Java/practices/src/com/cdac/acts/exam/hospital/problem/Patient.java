package com.cdac.acts.exam.hospital.problem;

import java.time.LocalDate;

public abstract class Patient {
    protected Integer patientId;
    protected String name;
    protected Integer age;
    protected LocalDate admissionDate;
    protected String department;
    protected PatientType patientType;

    public Patient(Integer patientId, String name, Integer age, LocalDate admissionDate, String department, PatientType patientType) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.admissionDate = admissionDate;
        this.department = department;
        this.patientType = patientType;
    }

    public abstract double calculateBill(int days);

    // Getters
    public Integer getPatientId() { return patientId; }
    public String getName() { return name; }
    public Integer getAge() { return age; }
    public LocalDate getAdmissionDate() { return admissionDate; }
    public String getDepartment() { return department; }
    public PatientType getPatientType() { return patientType; }
}
