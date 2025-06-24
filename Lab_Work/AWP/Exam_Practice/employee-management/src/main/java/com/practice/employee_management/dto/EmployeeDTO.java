package com.practice.employee_management.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Data;

@Data
public class EmployeeDTO {
    @NotBlank(message = "Name is required")
    private String name;

    @NotNull(message = "Salary is required")
    @Min(value = 30000, message = "Minimum salary is ₹30,000")
    @Max(value = 40000, message = "Maximum salary is ₹40,000")
    private Double salary;

    @NotNull(message = "Date of birth is required")
    @Past(message = "Date of birth must be in the past")
    private LocalDate dob;

    @NotNull(message = "Department is required")
    private Long departmentId;
}
