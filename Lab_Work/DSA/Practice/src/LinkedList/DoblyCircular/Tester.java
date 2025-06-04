package LinkedList.DoblyCircular;

public class Tester {

	public static void main(String[] args) {
		DoublyCircular dc = new DoublyCircular();
		
		dc.AddAtLast(1);
		dc.AddAtLast(2);
		dc.AddAtLast(3);
		dc.AddAtLast(4);
		dc.AddAtFront(0);
		dc.AddAtFront(-1);
		
		dc.deleteAtFront();
		
		dc.deleteAtLast();
		
		dc.deleteElement(3);

	
		

		
		dc.display();

	}

}
