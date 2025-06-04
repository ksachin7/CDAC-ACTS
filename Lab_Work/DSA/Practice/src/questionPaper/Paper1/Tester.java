package questionPaper.Paper1;

public class Tester {

	public static void main(String[] args) {
		DoublyList dl = new DoublyList();
		
		dl.addAtFront(1);
		dl.addAtFront(2);
		dl.addAtFront(3);
		dl.addAtFront(4);
		
		dl.addAtPostion(0, 40);
		
		dl.display();

	}

}
