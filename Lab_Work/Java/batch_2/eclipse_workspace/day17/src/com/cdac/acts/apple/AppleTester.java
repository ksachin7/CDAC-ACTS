package com.cdac.acts.apple;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class AppleTester {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			List<Apple> list = new LinkedList<>();
			
			list.add(new Apple("Red", 1.2, "Sweet"));
			list.add(new Apple("Red", 1.2, "Sweet"));
			list.add(new Apple("RedishGreen", 2.0, "BitterSweet"));
			list.add(new Apple("Green", 1.4, "Bitter"));
			list.add(new Apple("RedishGreen", 2.0, "BitterSweet"));
			list.add(new Apple("Green", 1.4, "Bitter"));
			
			while(true) {
				System.out.println("\n"
						+ "1. Filter by weight\r\n"
						+ "2. filter by color\r\n"
						+ "3. filter by color and weight\r\n"
						+ "4. filter by color, weight and taste\r\n"
						+ "5. Sort by weight\r\n"
						+ "6. Sort by color\r\n"
						+ "7. Remove red apples\r\n"
						+ "8. Removed Green apples\r\n"
						+ "9. Convert to Set collection\n"
						+ "10. Exit");
				
				int choice = sc.nextInt();
				
				switch(choice) {
				case 1:{
					list.stream().filter((x)->x.getWeight()>1.2).forEach((x)->System.out.println(x));
					break;
				}
				
				case 2:{
					list.stream().filter((x)->x.getColour()=="Red").forEach((x)->System.out.println(x));
					break;
				}
				
				case 3:{
					list.stream().filter((x)->x.getColour()=="Red" && x.getWeight()>1.1).forEach((x)->System.out.println(x));
					break;
				}
				
				case 4:{
					list.stream().filter((x)->x.getColour()=="Red" && x.getWeight()>1.1 && x.getTatse()=="Sweet").forEach((x)->System.out.println(x));
					break;
				}
				
				case 5:{
					list.stream().sorted((o1,o2)->o1.getWeight().compareTo(o2.getWeight())).forEach((x)->System.out.println(x));
					break;
				}
				
				case 6:{
					list.stream().sorted((o1,o2)->o1.getColour().compareTo(o2.getColour())).forEach((x)->System.out.println(x));
					break;
				}
				
				case 7:{
					list.stream().filter((x)->x.getColour()=="Red").forEach((x)->list.remove(x));
					System.out.println(list);
					break;
				}
				
				case 8:{
					// list.stream().filter((x)->x.getColour()=="Green").forEach((x)->list.remove(x)); // //  java.util.ConcurrentModificationException
					
					// filtering list without green apples
					List<Apple> filtered = list.stream()
	                          .filter(x -> !x.getColour().equals("Green"))
	                          .collect(Collectors.toList());

					System.out.println(filtered);
					System.out.println("After filter: " + list);
					
					// removing without stream
					list.removeIf(x->x.getColour().equalsIgnoreCase("Green"));
					System.out.println("After removal:" +list);
					
					break;
				}
				
				case 9:{
//			        Set<Apple> uniqueApples = new HashSet<>(list);
			        
			        // Using Stream to convert to Set
			        Set<Apple> uniqueApples = list.stream()
			                                       .collect(Collectors.toSet());
			        uniqueApples.stream().forEach(System.out::print);
//					list.stream().distinct().forEach((x)->System.out.println(x));
			        break;
				}
				
				case 10:{
					return;
				}
				
			}
			}
		}

	}

}
