package com.practice.employee_management.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.employee_management.dto.EmployeeDTO;
import com.practice.employee_management.model.Department;
import com.practice.employee_management.model.Employee;
import com.practice.employee_management.repository.DepartmentRepository;
import com.practice.employee_management.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository employeeRepo;
	
	@Autowired
	DepartmentRepository departmentRepo;
	
	@Override
	public void saveEmployee(EmployeeDTO empDTO) {
		Employee emp= new Employee();
		emp.setName(empDTO.getName());
		emp.setDob(empDTO.getDob());
		emp.setSalary(empDTO.getSalary());
		
		Department dept= departmentRepo.findById(empDTO.getDepartmentId())
				.orElseThrow(()-> new RuntimeException("Department not found"));
		
		int age= Period.between(empDTO.getDob(), LocalDate.now()).getYears();
		
		if(age < 25 || age > 35) {
			throw new IllegalArgumentException("Age must be between 25 and 35");
		}
		
		emp.setDepartment(dept);
		
		employeeRepo.save(emp);
	}

	@Override
	public List<Department> getAllDepartments() {
		return departmentRepo.findAll();
	}

}
