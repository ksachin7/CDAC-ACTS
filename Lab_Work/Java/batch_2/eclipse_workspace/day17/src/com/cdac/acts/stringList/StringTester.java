package com.cdac.acts.stringList;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StringTester {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			List<String> stringList = List.of("Pranit", "Kamble", "Sachin", "Kumar", "Pranav", "Chekare", "Pranit",
					"Kamble", "Sachin", "Kumar", "Pranav", "Chekare");

			while (true) {
				System.out.println("" 
						+ "1. print distinct\r\n" 
						+ "2. print all with uppercase\r\n"
						+ "3. print which starts with specific letter\r\n" 
						+ "4. concat all strings in the list\r\n"
						+ "5. filter by ending with some text" 
						+ "6. Exit");
				int choice = sc.nextInt();
				switch (choice) {
					case 1: {
						stringList.stream().distinct().forEach((x) -> System.out.println(x));
						break;
					}
					
					case 2: {
						stringList.stream().forEach((x) -> System.out.println(x.toUpperCase()));
						break;
					}
					
					case 3: {
						stringList.stream().filter((x) -> x.startsWith("P")).forEach((x) -> System.out.println(x));
						break;
					}
					
					case 4: {
						String str = stringList.stream().collect(Collectors.joining(" "));
						System.out.println(str);
						break;
					}
					
					case 5: {
						stringList.stream().filter((x) -> x.contains("re")).forEach((x) -> System.out.println(x));
						break;
					}
					
					case 6: {
						return;
					}
				}
			}
		}
	}

}