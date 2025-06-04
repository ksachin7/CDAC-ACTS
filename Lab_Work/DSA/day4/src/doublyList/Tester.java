package doublyList;

import Exception.ListIsEmpty;
import SortedDoublyList.SortedDoublyList;

public class Tester {

	public static void main(String[] args) {
		DoublyList d = new DoublyList();
		
		d.addAtRear(1);
		d.addAtRear(2);
		d.addAtRear(3);
		
		d.print();
		
		try {
			d.deleteFirstNode();
		} catch (ListIsEmpty e) {
			e.printStackTrace();
		}
		System.out.println("\nAfter deletion of first node ");
		d.print();
		
		
		SortedDoublyList sl = new SortedDoublyList();
		
		sl.insert(1);
		sl.insert(2);
		sl.insert(4);
		sl.insert(4);
		sl.insert(3);
		
		System.out.println("\nsorted List ");
		
		sl.print();
		
		sl.delete(1);
		
		System.out.println("\nAfter deletion of first node sorted list ");
		
		sl.print();
		
		sl.deleteAll(4);
		
		System.out.println("\nAfter deletion of first node sorted list ");
		
		sl.print();
		
		try {
			System.out.println("\nCheck if 3 is present");
			sl.search(3);
		} catch (ListIsEmpty e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
