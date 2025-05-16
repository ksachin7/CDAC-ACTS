
### **Problem Statement: Hospital Patient Management System**

You are tasked with implementing a **Hospital Patient Management System** that allows for managing patient records, including adding, discharging, displaying, filtering, and billing patients based on their type and admission details.

### **Classes and Inheritance:**

1. **Base Class: `Patient`**
    - The `Patient` class will be an **abstract** class and will have common fields and methods for all types of patients.
    - Fields in the `Patient` class include:
        - `patientId` (Integer): Unique identifier for each patient.
        - `name` (String): Name of the patient.
        - `age` (Integer): Age of the patient.
        - `admissionDate` (LocalDate): Date when the patient was admitted.
        - `department` (String): Department to which the patient is assigned (e.g., "Cardiology").
        - `patientType` (PatientType): Type of the patient, which is represented by an enum (`IN_PATIENT`, `OUT_PATIENT`, `EMERGENCY`).

2. **Subclasses of `Patient`:**
    - **`InPatient`**: Represents a patient who is admitted to the hospital.
        - Billing will be based on the number of days spent in the hospital.
    - **`OutPatient`**: Represents a patient who visits the hospital for consultation and treatment but is not admitted.
        - Billing will be a flat consultation fee.
    - **`EmergencyPatient`**: Represents a patient who requires urgent medical attention.
        - Billing will include an emergency charge plus a daily charge for the days the patient is in the hospital.

3. **Enum: `PatientType`**
    - This enum will contain three types of patients: `IN_PATIENT`, `OUT_PATIENT`, `EMERGENCY`.

---

### **Functional Requirements:**

1. **Adding a Patient Record:**
    - **Objective**: Add a new patient record to the system.
    - Use **polymorphism** to create a new patient based on the patient type. The correct subclass (`InPatient`, `OutPatient`, `EmergencyPatient`) will be used based on the patient type (`IN_PATIENT`, `OUT_PATIENT`, `EMERGENCY`).
    - Ensure the **patientId is unique** across all records.

2. **Discharging a Patient:**
    - **Objective**: Discharge a patient and remove them from the system by their `patientId`.
    - If the patient ID is invalid (does not exist) or the patient is already discharged, a **custom exception** (`PatientNotFoundException`) will be thrown.

3. **Displaying All Patients by Admission Date:**
    - **Objective**: Display all patients sorted by their admission date.
    - Use **Stream API** to sort and display the patients in the order they were admitted.

4. **Filtering Patients by Department:**
    - **Objective**: Filter patients by their department and sort the filtered patients by **name** and **age**.
    - Use **Stream API** for filtering and sorting.

5. **Billing Summary:**
    - **Objective**: Generate a billing summary for all patients based on their type.
    - Use **lambda expressions** to apply different billing logic:
        - For `InPatient`: Calculate the total bill based on the number of days they were admitted.
        - For `OutPatient`: Apply a flat consultation fee.
        - For `EmergencyPatient`: Add a fixed emergency charge and calculate the daily stay charges.

---

### **Technical Requirements:**

1. **Inheritance and Polymorphism:**
    - Use **inheritance** to represent different types of patients (i.e., `InPatient`, `OutPatient`, and `EmergencyPatient`).
    - Use **polymorphism** to process different patient types and apply the correct billing logic.

2. **Stream API:**
    - Use **Stream API** to filter, sort, and process collections of patients. This will be used for displaying and filtering patients by their admission date and department.

3. **Collections:**
    - Store the list of patients in a **`List<Patient>`**.
    - Ensure the list allows for adding, removing, and displaying patients.

4. **Custom Exception:**
    - Define a **custom exception** (`PatientNotFoundException`) to handle invalid operations, such as attempting to discharge a non-existing patient.

---

### **Example Usage:**

```java
// Create instances of different patients
PatientManager manager = new PatientManager();
manager.addPatient(new InPatient(1, "John", 30, LocalDate.of(2025, 4, 20), "Cardiology"));
manager.addPatient(new OutPatient(2, "Alice", 25, LocalDate.of(2025, 4, 22), "Orthopedics"));
manager.addPatient(new EmergencyPatient(3, "Bob", 40, LocalDate.of(2025, 4, 21), "Emergency"));

// Display all patients sorted by admission date
manager.displayPatientsByAdmissionDate();

// Filter patients by department and sort by name and age
manager.filterAndSortByDepartment("Emergency");

// Generate billing summary
manager.billingSummary(3);  // For example, 3 days stay

// Discharge a patient by ID
try {
    manager.dischargePatient(2);  // Discharge patient with ID 2
} catch (PatientNotFoundException e) {
    System.out.println(e.getMessage());
}
```

---

### **Edge Cases to Consider:**
- **Duplicate patient IDs**: Ensure that no two patients have the same ID.
- **Patient already discharged**: Handle attempts to discharge patients who are no longer in the system.
- **Invalid patient ID**: Throw a custom exception when a patient with the provided ID is not found.

---

