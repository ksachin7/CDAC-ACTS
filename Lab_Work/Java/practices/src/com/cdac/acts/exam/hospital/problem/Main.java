package com.cdac.acts.exam.hospital.problem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        PatientManager manager = new PatientManager();

        manager.addPatient(new InPatient(1, "John", 30, LocalDate.of(2025, 4, 20), "Cardiology"));
        manager.addPatient(new OutPatient(2, "Alice", 25, LocalDate.of(2025, 4, 22), "Orthopedics"));
        manager.addPatient(new EmergencyPatient(3, "Bob", 40, LocalDate.of(2025, 4, 21), "Emergency"));

        System.out.println("\n--- Display by Admission Date ---");
        manager.displayPatientsByAdmissionDate();

        System.out.println("\n--- Filter by Department: Emergency ---");
        manager.filterAndSortByDepartment("Emergency");

        System.out.println("\n--- Billing Summary for 3 Days ---");
        manager.billingSummary(3);

        try {
            System.out.println("\n--- Discharging Patient with ID 2 ---");
            manager.dischargePatient(2);
        } catch (PatientNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n--- Display After Discharge ---");
        manager.displayPatientsByAdmissionDate();
    }
}
