package eclipse_workspace.day12.tester;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.cdac.acts.fruits.Fruit;

class FruitManager {

	public static void main(String[] args) {
		List<Fruit> fruitList = new LinkedList<>();
		Scanner scanner = new Scanner(System.in);
		int choice = -1;

		do {
			System.out
					.println("1. Add fruit\n" + "2. Display Friut List\n" + "3. Sort fruits by color (natural order)\n"
							+ "4. Sort by quantity\n" + "5. Sort by price\n" + "6. Exit");
			choice = scanner.nextInt();
			switch (choice) {
			case 1: {
//				 fruitList.add(new Fruit("Apple", "Red", 1.2, 10));
//			     fruitList.add(new Fruit("Banana", "yellow", 0.5, 20));
//			     fruitList.add(new Fruit("Orange", "Orange", 0.8, 15));
		        
				System.out.print("Enter name: ");
				String name = scanner.next();
				scanner.nextLine();

				System.out.print("Enter color: ");
				String color = scanner.nextLine();

				System.out.print("Enter price: ");
				double price = scanner.nextDouble();

				System.out.print("Enter quantity: ");
				int quantity = scanner.nextInt();
				scanner.nextLine();

				fruitList.add(new Fruit(name, color, price, quantity));
				System.out.println("Fruit added!");
				break;
			}

			case 2: {
				System.out.println(fruitList);
				break;
			}

			case 3: {
				Comparator<Fruit> colorComparator = new Comparator<Fruit>() {

					@Override
					public int compare(Fruit o1, Fruit o2) {
						return o1.getColor().compareTo(o2.getColor());
					}
				};
				Collections.sort(fruitList, colorComparator);
				break;
			}
			case 4: {
				Comparator<Fruit> qtyComparator = new Comparator<Fruit>() {
					@Override
					public int compare(Fruit p1, Fruit p2) {
						return p1.getQuantity().compareTo(p2.getQuantity());
					}

				};
				Collections.sort(fruitList, qtyComparator);
				break;
			}

			case 5: {
				Comparator<Fruit> priceComparator = new Comparator<Fruit>() {
					@Override
					public int compare(Fruit p1, Fruit p2) {
						return p1.getPrice().compareTo(p2.getPrice());
					}
				};
				Collections.sort(fruitList, priceComparator);
				break;
			}

			case 6:
				return;

			default:
				System.out.println("Invalid choice!");
			}
		} while (choice != 6);
		scanner.close();
	}
}