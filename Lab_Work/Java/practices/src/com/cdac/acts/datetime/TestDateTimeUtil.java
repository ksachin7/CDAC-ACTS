package com.cdac.acts.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TestDateTimeUtil {
    public static void main(String[] args) {
        String dateStr = "11-04-2025";
        String dateTimeStr = "11-04-2025 14:30:00";

        // Parse date
        LocalDate date = DateTimeUtil.parseDate(dateStr);
        System.out.println("Parsed LocalDate: " + date);

        // Format date
        System.out.println("Formatted LocalDate: " +
                DateTimeUtil.formatDate(date, "EEEE, MMMM dd, yyyy"));

        // Parse dateTime
        LocalDateTime dateTime = DateTimeUtil.parseDateTime(dateTimeStr);
        System.out.println("Parsed LocalDateTime: " + dateTime);

        // Format dateTime
        System.out.println("Formatted LocalDateTime: " +
                DateTimeUtil.formatDateTime(dateTime, "dd/MM/yyyy hh:mm a"));

        // Validation
        System.out.println("Is valid date: " + DateTimeUtil.isValidDate("29-02-2024", "dd-MM-yyyy")); // true
        System.out.println("Is valid datetime: " + DateTimeUtil.isValidDateTime("31-02-2025 12:00:00", "dd-MM-yyyy HH:mm:ss")); // false
    }
}

