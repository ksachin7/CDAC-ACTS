package LinkedList.SinglyCircular;

public class Tester {

	public static void main(String[] args) {
		SinglyCircular sl = new SinglyCircular();
		
		sl.addAtLast(1);
		sl.addAtLast(2);
		sl.addAtLast(3);
		sl.addAtFront(0);
		sl.deleteAtFront();
		sl.deleteAtLast();
		
		sl.display();

	}

}
