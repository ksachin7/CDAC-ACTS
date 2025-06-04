package LinkedList;

import SortedList.SortedSinglyList;

public class Tetser {

	public static void main(String[] args) {
		List l1 = new SinglyList();
		
		l1.addAtFront(1);
		l1.addAtFront(2);
		l1.addAtFront(3);
		l1.addAtFront(4);
		
		l1.print();
		
		System.out.println("Sorted List");
		
		
		SortedSinglyList sl = new SortedSinglyList();
		
		sl.insert(1);
		sl.insert(3);
		sl.insert(2);
		sl.insert(2);
		sl.insert(3);
		sl.insert(4);
		
		
		sl.print();
		
		sl.delete(1);
		
		System.out.println("\nAfter Deletion of 1");
		
		sl.print();
		
		System.out.println("\nAfter Finding element in list");
		
		sl.search(0);
		
		sl.deleteAll(3);
		
		System.out.println("\nAfter deleting all 3");
		
		sl.print();

	}

}
