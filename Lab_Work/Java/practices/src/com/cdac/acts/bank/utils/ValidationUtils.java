package com.cdac.acts.bank.utils;

import com.cdac.acts.bank.exception.InvalidAccountException;

public class ValidationUtils {

    public static void validate(String email, String phone, double amount, String password) throws InvalidAccountException {
        validateEmail(email);
        validateAmount(amount);
        validatePhone(phone);
        validatePassword(password);
    }

    public static void validateEmail(String email) throws InvalidAccountException {
        if (!email.contains("@") || email.length() < 5)
            throw new InvalidAccountException("Invalid email format");
    }

    public static void validatePhone(String phone) throws InvalidAccountException {
        if (!phone.matches("\\d{10}"))
            throw new InvalidAccountException("Phone must be 10 digits");
    }

    public static void validateAmount(double amount) throws InvalidAccountException {
        if (amount <= 0)
            throw new InvalidAccountException("Amount must be greater than 0");
    }

    public static void validatePassword(String password) throws InvalidAccountException {
        if (password == null || password.length() < 6)
            throw new InvalidAccountException("Password must be at least 6 characters");
    }
}

