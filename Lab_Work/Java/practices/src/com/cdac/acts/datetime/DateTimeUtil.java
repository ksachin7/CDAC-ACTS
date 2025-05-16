package com.cdac.acts.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateTimeUtil {

    // Default patterns
    public static final String DEFAULT_DATE_PATTERN = "dd-MM-yyyy";
    public static final String DEFAULT_DATETIME_PATTERN = "dd-MM-yyyy HH:mm:ss";

    // Format LocalDate to String
    public static String formatDate(LocalDate date) {
        return formatDate(date, DEFAULT_DATE_PATTERN);
    }

    public static String formatDate(LocalDate date, String pattern) {
        if (date == null || pattern == null) return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return date.format(formatter);
    }

    // Format LocalDateTime to String
    public static String formatDateTime(LocalDateTime dateTime) {
        return formatDateTime(dateTime, DEFAULT_DATETIME_PATTERN);
    }

    public static String formatDateTime(LocalDateTime dateTime, String pattern) {
        if (dateTime == null || pattern == null) return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return dateTime.format(formatter);
    }

    // Parse String to LocalDate
    public static LocalDate parseDate(String dateStr) {
        return parseDate(dateStr, DEFAULT_DATE_PATTERN);
    }

    public static LocalDate parseDate(String dateStr, String pattern) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
            return LocalDate.parse(dateStr, formatter);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    // Parse String to LocalDateTime
    public static LocalDateTime parseDateTime(String dateStr) {
        return parseDateTime(dateStr, DEFAULT_DATETIME_PATTERN);
    }

    public static LocalDateTime parseDateTime(String dateStr, String pattern) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
            return LocalDateTime.parse(dateStr, formatter);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    // Validate date string
    public static boolean isValidDate(String dateStr, String pattern) {
        return parseDate(dateStr, pattern) != null;
    }

    // Validate date-time string
    public static boolean isValidDateTime(String dateStr, String pattern) {
        return parseDateTime(dateStr, pattern) != null;
    }
}
