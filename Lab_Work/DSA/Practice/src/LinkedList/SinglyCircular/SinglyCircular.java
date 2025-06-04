package LinkedList.SinglyCircular;

public class SinglyCircular {
	Node head;
	
	public SinglyCircular() {
		this.head = null;
	}
	
	public void addAtLast(int element) {
		Node newNode = new Node();
		newNode.data = element;
		
		if(head == null) {
			head = newNode;
			head.next = head;
			return;
		}
		if(head.next == head) {
			head.next = newNode;
			newNode.next = head;
			return;
		}
		
		Node current = head;
		while(current.next != head) {
			current = current.next;
		}
		current.next = newNode;
		newNode.next = head;
	}
	
	public void addAtFront(int element) {
		Node newNode = new Node();
		newNode.data = element;
		
		if(head == null) {
			head = newNode;
			head.next = head;
			return;
		}
		if(head.next == head) {
			head.next = newNode;
			newNode.next = head;
			return;
		}
		Node current = head;
		while(current.next != head) {
			current = current.next;
		}
		current.next = newNode;
		newNode.next = head;
		head = newNode;
	}
	
	public void deleteAtFront() {
		if(head == null) {
			return;
		}
		if(head.next == head) {
			head = null;
			return;
		}
		Node current = head;
		while(current.next != head) {
			current = current.next;
		}
		current.next = head.next;
		head = current.next;
	}
	
	public void deleteAtLast() {
		if(head == null) {
			return;
		}
		if(head.next == head) {
			head = null;
			return;
		}
		Node current = head;
		while(current.next.next != head) {
			current = current.next;
		}
		current.next = head;
		
	}
	
	public void display() {
		Node current = head;
		if(head == null) {
			return;
		}
		do {
			System.out.print(current.data+" ");
			current = current.next;
		}while(current != head);
	}

}
