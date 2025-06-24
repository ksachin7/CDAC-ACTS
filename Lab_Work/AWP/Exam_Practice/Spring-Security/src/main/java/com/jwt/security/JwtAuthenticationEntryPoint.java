package com.jwt.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
            throws IOException, ServletException {
        // Set the response status to 401 (Unauthorized)
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        // Set the response content type
        response.setContentType("application/json");

        // Create a response message
        String errorMessage = String.format("{\"error\": \"Access Denied! Unauthorized access attempted.\", \"message\": \"%s\"}",
                authException.getMessage());

        // Write the error message to the response
        try (PrintWriter writer = response.getWriter()) {
            writer.write(errorMessage);
            writer.flush();
        }
    }
}
