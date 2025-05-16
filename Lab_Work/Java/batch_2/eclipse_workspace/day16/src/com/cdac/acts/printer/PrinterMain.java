package com.cdac.acts.printer;

import java.time.LocalDate;
import java.util.*;

public class PrinterMain {
    public static void main(String[] args) {
        HashMap<String, Printer> printerMap = PrinterIO.loadPrinters();
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n=== Printer Menu ===");
            System.out.println("1. Add Printer");
            System.out.println("2. Update Printer Price");
            System.out.println("3. Print All Printers");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 : {
                    sc.nextLine(); // consume newline
                    
                    System.out.print("Enter Serial No: ");
                    String serial = sc.nextLine();
                    
                    System.out.print("Enter Model No: ");
                    String model = sc.nextLine();
                    
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    
                    sc.nextLine();
                    
                    System.out.print("Enter Printer Type (LASER/INKJET/DOTMATRIX): ");
                    PrinterType type = PrinterType.valueOf(sc.nextLine().toUpperCase());
                    
                    System.out.print("Enter Manufacturing Date (yyyy-MM-dd): ");
                    LocalDate mfgDate = LocalDate.parse(sc.nextLine());

                    Printer printer = new Printer(serial, model, price, type, mfgDate);
                    printerMap.put(serial, printer);
                    
                    System.out.println("Printer added.");
                }
                break;
                case 2 : {
                    sc.nextLine();
                    
                    System.out.print("Enter Serial No to update price: ");
                    String serial = sc.nextLine();
                    
                    Printer p = printerMap.get(serial);
                    if (p != null) {
                        System.out.print("Enter new price: ");
                        double newPrice = sc.nextDouble();
                        p.setPrice(newPrice);
                        System.out.println("Price updated.");
                    } else {
                        System.out.println("Printer not found.");
                    }
                }
                break;
                case 3 : {
                    if (printerMap.isEmpty()) {
                        System.out.println("No printers found.");
                    } else {
                        System.out.println("\n--- All Printers ---");
                        for (Printer p : printerMap.values()) {
                            System.out.println(p);
                        }
                    }
                }
                break;
                case 4 : {
                    PrinterIO.savePrinters(printerMap);
                    System.out.println("Data saved. Exiting.");
                    exit = true;
                }
                break;
                default : System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}
