package com.cdac.acts.Restaurents;

import java.util.Scanner;
import com.cdac.acts.Restaurents.Item;
import com.cdac.acts.Restaurents.Customer;

public class Main {
	private static double totalPrice;
	private static int size = 50;
	private static Customer[] customers = new Customer[size];
	// private static String items[] = { "food1", "food2", "food3" };
	// private static double prices[] = { 310, 250, 100 };
	// private static int stocks[] = { 10, 10, 10 };
	private static Item []bill= new Item[size];

	public static double getTotalPrice() {
		return totalPrice;
	}

	public static void setTotalPrice(double totalPrice) {
		Main.totalPrice = totalPrice;
	}

	static void buyItemByItemCode(int code, Item []items, int qty){
		// decrease stock
		// add in bill
		for (int i = 0; i < items.length; i++) {
			int quantity= items[i].getQty();
			double totalItemPrice= items[i].getPrice()*qty;
			int billIdx=0;

			if(items[i].getItemCode() == code){
				items[i].setQty(quantity-qty);
				if (bill[i] == null) {
					bill[i] = new Item(items[i].getItemCode(), items[i].getItemName(), items[i].getPrice(), 0);
				}
				bill[billIdx].setQty(qty);
				bill[billIdx].setPrice(totalItemPrice);
				totalPrice+=totalItemPrice;
				billIdx++;
				break;
			}
		}
	}


	public static void main(String[] args) {
		Main obj= new Main();
		Customer cust1 = new Customer();
		Item item = new Item();
		Item []items = {
				new Item(001, "Butter Chicken", 500, 10),  
				new Item(002, "Paneer Tikka", 350, 15),    
				new Item(003, "Chole Bhature", 200, 20),   
				new Item(004, "Aloo Paratha", 120, 30),    
				new Item(005, "Tandoori Roti", 50, 50),    
				new Item(006, "Dosa", 100, 25),              
				new Item(007, "Idli Sambhar", 50, 40),
//				new Item(008, "Sambhar Vada", 150, 15),
//				new Item(009, "Chicken Briyani", 120, 30),
		};
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("Menu: \r\n" 
				+ "0. Exit.\r\n"
				+ "1. Display stock\r\n" 
				+ "2. BUY item by item code\r\n"
				+ "3. Display bill"
			);

			int choice = sc.nextInt();

			switch (choice) {
				case 1: {
					System.out.println("+--------------------++--------------------+");
					System.out.println("Item ID\tItem Name\t\t\tStock\tPrice");
					for(Item i: items){
						System.out.println(i.getItemCode()+"\t\t"+i.getItemName()+"\t\t"+i.getQty()+"\t\t\t"+i.getPrice());
					}
					System.out.println("+--------------------++--------------------+");
					break;
				}
				case 2:{
					System.out.println("Please enter item id for the food you want to buy: ");
					int itemId= sc.nextInt();
					System.out.println("Please enter the quantity: ");
					int quantity= sc.nextInt();

					buyItemByItemCode(itemId, items, quantity);
					break;
				}
				case 3:{
					System.out.println("+---------------+Bill+---------------+");
					System.out.println("Item-id\tItem Name\tQuantity\tPrice");
					for(int i=0; i<items.length; i++){
						if(items[i] != null && bill[i] != null) {
							System.out.println(items[i].getItemCode()+"\t\t"+items[i].getItemName()+"\t\t"+bill[i].getQty()+ "\t\t\t"+items[i].getPrice());
						}else break;
					}
					System.out.println("+-----------------++-----------------+");
					System.out.println("Total: "+getTotalPrice()+"\n");
					break;
				}
				case 0: return;
				default: System.out.println("Invalid choice!");

			}
		}

	}

}
