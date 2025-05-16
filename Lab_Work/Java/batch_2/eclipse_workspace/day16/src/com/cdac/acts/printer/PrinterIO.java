package com.cdac.acts.printer;

import java.io.*;
import java.nio.file.Paths;
import java.util.HashMap;

public class PrinterIO {
    private static final String FILE_NAME = "printers.dat";
    private static final File file = Paths.get("src/printers_data", FILE_NAME).toFile();

    public static void savePrinters(HashMap<String, Printer> printers) {
        file.getParentFile().mkdirs();

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(printers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static HashMap<String, Printer> loadPrinters() {
//        File file = new File(FILE_NAME);
    	 if (!file.exists()) {
             System.out.println("No saved data found. Starting fresh.");
             return new HashMap<>();
         }
    	 
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (HashMap<String, Printer>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }
}
