package com.practice.employee_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.practice.employee_management.dto.EmployeeDTO;
import com.practice.employee_management.service.EmployeeService;

import jakarta.validation.Valid;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees/new")
    public String showForm(Model model) {
        model.addAttribute("employeeDTO", new EmployeeDTO());
        model.addAttribute("departments", employeeService.getAllDepartments());
        return "employee-form";
    }

    @PostMapping("/employees")
    public String saveEmployee(@Valid @ModelAttribute("employeeDTO") EmployeeDTO employeeDTO,
                               BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("departments", employeeService.getAllDepartments());
            return "employee-form";
        }

        try {
            employeeService.saveEmployee(employeeDTO);
        } catch (IllegalArgumentException ex) {
            result.rejectValue("dob", null, ex.getMessage());
            model.addAttribute("departments", employeeService.getAllDepartments());
            return "employee-form";
        }

        return "redirect:/departments";
    }

    @GetMapping("/departments")
    public String listDepartments(Model model) {
        model.addAttribute("departments", employeeService.getAllDepartments());
        return "departments";
    }
}
