package com.cdac.acts.person;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class PersonManager {
    private static LinkedHashMap<String, Person> people = new LinkedHashMap<>();
    private static Scanner scanner = new Scanner(System.in);
    private static final String FILE_NAME = "people.dat";
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Add Person");
            System.out.println("2. Display All Persons");
            System.out.println("3. Find by Name");
            System.out.println("4. Save to File");
            System.out.println("5. Load from File");
            System.out.println("6. Display Sorted by District");
            System.out.println("7. Display Sorted by Name");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt(); scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addPerson();
                case 2 -> displayAll();
                case 3 -> findByName();
                case 4 -> saveToFile();
                case 5 -> loadFromFile();
                case 6 -> displaySortedByDistrict();
                case 7 -> displaySortedByName();
                case 8 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void addPerson() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        if (people.containsKey(name)) {
            System.out.println("Person with this name already exists.");
            return;
        }

        try {
            System.out.print("Enter birth date (dd/MM/yyyy): ");
            String dateStr = scanner.nextLine();
            Date dob = sdf.parse(dateStr);

            System.out.print("Enter area: ");
            String area = scanner.nextLine();

            System.out.print("Enter district: ");
            String district = scanner.nextLine();

            System.out.print("Enter pin: ");
            int pin = scanner.nextInt(); scanner.nextLine();

            PersonAddress address = new PersonAddress(area, district, pin);
            Person person = new Person(name, dob, address);

            people.put(name, person);
            System.out.println("Person added successfully.");
        } catch (ParseException e) {
            System.out.println("Invalid date format.");
        }
    }

    private static void displayAll() {
        if (people.isEmpty()) {
            System.out.println("No people in the system.");
        } else {
            people.values().forEach(System.out::println);
        }
    }

    private static void findByName() {
        System.out.print("Enter name to find: ");
        String name = scanner.nextLine();
        Person person = people.get(name);
        if (person != null) {
            System.out.println(person);
        } else {
            System.out.println("Person not found.");
        }
    }

    private static void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(people);
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    private static void loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            Object obj = ois.readObject();
            if (obj instanceof LinkedHashMap<?, ?>) {
                people = (LinkedHashMap<String, Person>) obj;
                System.out.println("Data loaded successfully.");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
    }

    private static void displaySortedByDistrict() {
        people.values().stream()
                .sorted(Comparator.comparing(p -> p.getAddress().getDistrict()))
                .forEach(System.out::println);
    }

    private static void displaySortedByName() {
        people.values().stream()
                .sorted(Comparator.comparing(Person::getName))
                .forEach(System.out::println);
    }
}
