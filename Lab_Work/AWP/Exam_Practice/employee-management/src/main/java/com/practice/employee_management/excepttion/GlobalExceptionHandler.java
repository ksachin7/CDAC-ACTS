package com.practice.employee_management.excepttion;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
    @ExceptionHandler(Exception.class)
    public String handleError(Model model, Exception ex) {
        model.addAttribute("error", ex.getMessage());
        return "error";
    }
}
