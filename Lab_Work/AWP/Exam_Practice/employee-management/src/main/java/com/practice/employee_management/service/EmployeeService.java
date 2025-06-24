package com.practice.employee_management.service;

import java.util.List;

import com.practice.employee_management.dto.EmployeeDTO;
import com.practice.employee_management.model.Department;

public interface EmployeeService {
	void saveEmployee(EmployeeDTO empDTO);
	List<Department> getAllDepartments();
}
