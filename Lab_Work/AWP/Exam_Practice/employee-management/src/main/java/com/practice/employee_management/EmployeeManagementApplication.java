package com.practice.employee_management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.practice.employee_management.model.Department;
import com.practice.employee_management.repository.DepartmentRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class EmployeeManagementApplication implements CommandLineRunner {

	@Autowired
	DepartmentRepository deptRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementApplication.class, args);
	}

	@Override
    @Transactional
	public void run(String... args) throws Exception {		
        if (deptRepo.count() == 0) {
            Department d1 = new Department();
            d1.setName("HR");

            Department d2 = new Department();
            d2.setName("IT");

            Department d3 = new Department();
            d3.setName("Finance");

            deptRepo.save(d1);
            deptRepo.save(d2);
            deptRepo.save(d3);
            
            log.info("Demo departments created.");
//            System.out.println("Demo departments created.");
        }

	}
}
