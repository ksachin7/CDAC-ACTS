package questionPaper.Paper1;

public class DoublyList {
	Node head;
	
	public DoublyList() {
		this.head = null;
	}
	
	public void addAtFront(int element) {
		Node newNode = new Node();
		newNode.data = element;
		
		if(head == null) {
			head = newNode;
			head.next = head;
			head.prev = head;
			return;
		}
		head.prev.next = newNode;
		newNode.prev = head.prev;
		newNode.next = head;
		head.prev = newNode;
	}
	
	public void addAtPostion(int position,int element) {
		Node newNode = new Node();
		newNode.data = element;
		
		if(head == null) {
			head = newNode;
			head.next = head;
			head.prev = head;
			return;
		}
		if(position == 0) {
			newNode.next = head;
			newNode.prev = head.prev;
			head.prev.next = newNode;
			head.prev = newNode;
			head = newNode;
			return;
		}
		Node current = head;
		for(int i=0;i<position-1;i++) {
			if(current == null) {
				break;
			}
			current = current.next;
		}
		newNode.next = current.next;
		newNode.prev = current;
		current.next.prev = newNode;
		current.next = newNode;
		
		
	}
	
	public void display() {
		if(head == null) {
			return;
		}
		Node current = head;
		do {
			System.out.print(current.data + " ");
			current = current.next;
		}
		while(current != head);
	}
	
}
