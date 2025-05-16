package com.cdac.acts.exam.hospital.problem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PatientManager {
    private List<Patient> patientList = new ArrayList<>();

    // Add patient
    public void addPatient(Patient patient) {
        if (patientList.stream().anyMatch(p -> p.getPatientId().equals(patient.getPatientId()))) {
            System.out.println("Duplicate Patient ID not allowed.");
            return;
        }
        patientList.add(patient);
        System.out.println("Patient added: " + patient.getName());
    }

    // Discharge patient
    public void dischargePatient(int id) throws PatientNotFoundException {
        Optional<Patient> patient = patientList.stream().filter(p -> p.getPatientId().equals(id)).findFirst();
        if (patient.isPresent()) {
            patientList.remove(patient.get());
            System.out.println("Patient discharged: " + patient.get().getName());
        } else {
            throw new PatientNotFoundException("Patient with ID " + id + " not found or already discharged.");
        }
    }

    // Display all patients by admission date
    public void displayPatientsByAdmissionDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        patientList.stream()
                .sorted(Comparator.comparing(Patient::getAdmissionDate))
                .forEach(p -> System.out.println(p.getName() + " | " + p.getAdmissionDate().format(formatter)));
    }

    // Filter by department and sort by name then age
    public void filterAndSortByDepartment(String department) {
        patientList.stream()
                .filter(p -> p.getDepartment().equalsIgnoreCase(department))
                .sorted(Comparator.comparing(Patient::getName).thenComparing(Patient::getAge))
                .forEach(p -> System.out.println(p.getName() + " | " + p.getAge()));
    }

    // Billing summary using lambda
    public void billingSummary(int days) {
        patientList.forEach(p -> {
            double bill = p.calculateBill(days);
            System.out.println(p.getName() + " (" + p.getPatientType() + ") - ₹" + bill);
        });
    }
}
