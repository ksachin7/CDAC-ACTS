package LinkedList.DoblyCircular;

public class DoublyCircular {
	Node head;
	
	public DoublyCircular() {
		this.head = null;
	}

	public void AddAtLast(int element) {
		Node newNode = new Node();
		newNode.data = element;
		
		if(head == null) {
			head = newNode;
			head.next = head;
			head.prev = head;
			return;
		}
		if(head.next == head) {
			head.next = newNode;
			head.prev = newNode;
			newNode.prev = head;
			newNode.next = head;
			return;
			
			
		}
		Node current = head;
		while(current.next != head) {
			current = current.next;
		}
		current.next = newNode;
		newNode.next = head;
		head.prev = newNode;
		newNode.prev = current;
	}
	
	public void AddAtFront(int element) {
		Node newNode = new Node();
		newNode.data = element;
		
		if(head == null) {
			head = newNode;
			head.next = head;
			head.prev = head;
			return;
		}
		if(head.next == head) {
			head.next = newNode;
			newNode.next = head;
			head.prev = newNode;
			newNode.prev = head;
			head = newNode;
			return;
		}
		Node current = head;
		while(current.next != head) {
			current = current.next;
		}
		current.next = newNode;
		newNode.next = head;
		head.prev = newNode;
		newNode.prev = current;
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
		head.next.prev = current;
		head = head.next;
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
		head.prev = current;
	}
	
	public void deleteElement(int element) {
		if(head == null) {
			return;
		}
		if(head.data == element && head.next == head) {
			head = null;
			return;
		}
		
		if(head.data == element && head.next !=head) {
			head.prev.next = head.next;
			head.next.prev = head.prev;
			head = head.next;
			return;
		}
		
		Node current = head.next;
		while(current != head) {
			if(current.data == element) {
				current.prev.next = current.next;
				current.next.prev = current.prev;
				return;
			}
			current = current.next;
		}
		
	}
	
	public void display() {
		if(head == null) {
			System.out.println("List is empty");
			return;
		}
		Node current = head;
		do {
			System.out.print(current.data + " ");
			current = current.next;
		}while(current != head);
	}
}
