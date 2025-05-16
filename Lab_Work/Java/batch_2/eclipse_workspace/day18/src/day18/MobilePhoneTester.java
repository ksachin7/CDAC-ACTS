package day18;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class MobilePhoneTester {

	public static void main(String[] args) {

		// Adding some demo data
		System.out.println("Adding some test data...");
		MobilePhone.addPhone(new MobilePhone(12345, "Samsung", "Android", "Black", 10999.99, "8GB"));
		MobilePhone.addPhone(new MobilePhone(67890, "Apple", "iOS", "Space Gray", 89999.50, "6GB"));
		MobilePhone.addPhone(new MobilePhone(13579, "Xiaomi", "Android", "Blue", 19999.00, "12GB"));

		Scanner scanner = new Scanner(System.in);
		int choice;

		do {
			System.out.println("\n--- Mobile Phone Menu ---");
			System.out.println("1. Add New Phone");
			System.out.println("2. Display All Phones");
			System.out.println("3. Partition Android & Iphone");
			System.out.println("4. Sort Phone");
			System.out.println("5. Convert to Set");
			System.out.println("6. Filter by every field");
			System.out.println("0. Exit");
			System.out.print("Enter your choice: ");

			choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			switch (choice) {
			case 1:
				System.out.println("Adding new phone...");
				break;
				
			case 2:
				MobilePhone.displayAllPhones();
				break;
			case 3: 
				Map<Boolean, List<MobilePhone>> partitioned = phones.stream()
				    .collect(Collectors.partitioningBy(p -> p.getOs().equalsIgnoreCase("Android")));

				System.out.println("Android Phones: " + partitioned.get(true));
				System.out.println("iOS Phones: " + partitioned.get(false));

				break;
			case 4:
				List<MobilePhone> sortedList = MobilePhone.phoneList.stream()
						.sorted(Comparator
							.comparing(MobilePhone::getColor)
				        .thenComparing(MobilePhone::getWeight))
						.collect(Collectors.toList());
				sortedList.stream().forEach(System.out::println);
				break;
				
			case 5:
				Set<MobilePhone> phoneSet = MobilePhone.phoneList.stream().collect(Collectors.toSet());
				phoneSet.forEach(System.out::println);
				break;
				
			case 6:
				// using predicate
//				Predicate<MobilePhone> predicate = (x) -> x.getColor().equals("Black")
//						&& x.getBrand().equals("Samsung");
//				
//				List<MobilePhone> filteredList = MobilePhone.filterbyCriteria(MobilePhone.phoneList, predicate);
//				for (MobilePhone mp : filteredList) {
//					System.out.println(mp);
//				}
				
				// using Stream
				MobilePhone.phoneList.stream().filter(p -> p.getColor().equals("Black")
						&& p.getBrand().equals("Samsung")).forEach(System.out::println);;
				break;
				
			case 0:
				System.out.println("Exiting the application. Goodbye!");
				break;
				
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		} while (choice != 0);

		scanner.close();
	}

}
