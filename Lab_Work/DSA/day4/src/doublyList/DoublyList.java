package doublyList;

import Exception.ListIsEmpty;

public class DoublyList implements List{
	dNode head;
	dNode tail;
	
	public DoublyList() {
		head = null;
		tail = null;
	}

	@Override
	public void addAtFront(int element) {
		
		dNode newNode = new dNode();
		newNode.data = element;
		newNode.previous = null;
		newNode.next = null;
		if(isEmpty()) {
			head = newNode;
			tail = newNode;
			return;
		}
		newNode.next = head;
		head.previous = newNode;
		head = newNode;
		
		
		
	}

	@Override
	public void addAtRear(int element) {
		dNode newNode = new dNode();
		newNode.data = element;
		newNode.next = null;
		newNode.previous = null;
		
		if(isEmpty()) {
			head = newNode;
			tail = head;
			return;
		}
		tail.next = newNode;
		newNode.previous = tail;
		tail = newNode;
		
	}

	@Override
	public int deleteFirstNode() throws ListIsEmpty {
		if(isEmpty()) {
			throw new ListIsEmpty("List is Empty cannot remove");
		}
		if(head.next==null) {
			head = null;
			tail = null;
			return -1;
		}
		dNode temp = head;
		head = head.next;
		head.previous = null;
		
		return temp.data;
	}

	@Override
	public boolean isEmpty() {
		if(head == null) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public void print() {
		dNode current = head;
		while(current != null) {
			System.out.print(current.data+" -> ");
			current = current.next;
		}
		
	}

}
