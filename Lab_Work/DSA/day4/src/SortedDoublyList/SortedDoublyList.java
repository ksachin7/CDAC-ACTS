package SortedDoublyList;

import Exception.ListIsEmpty;
import doublyList.dNode;

public class SortedDoublyList implements SortedList{
	dNode head;
	dNode tail;
	
	public SortedDoublyList(){
		head = null;
		tail = null;
	}

	@Override
	public void insert(int element) {
		dNode newNode = new dNode();
		newNode.data = element;
		newNode.previous = null;
		newNode.next = null;
		
		if(head == null) {
			head = newNode;
			tail = head;
//			System.out.println("Node aaded"+head.data);
			return;
		}
		dNode current = head;
		while(current != null) {
			if(current.data > element) {

				break;
			}
			current = current.next;
		}
		if(current == head) {
			newNode.next = head;
			head.previous = newNode;
			head = newNode;
			return;
		}
		if(current == null) {
			tail.next = newNode;
			newNode.previous = tail;
			tail = newNode;
			return;
		}
		current.previous.next = newNode;
		newNode.previous = current.previous;
		newNode.next = current;
		current.previous = newNode;
//		System.out.println("Node Added"+newNode.data);
		
		
	}
	
	public void delete(int element) {
		
		dNode current = head;
		while(current != null) {
			if(current.data == element) {
				break;
			}
			current = current.next;
		}
		if(current == head) {
			head = head.next;
			return;
		}
		if(head == null) {
			System.out.println("List is empty");
			tail = null;
			return;
		}else{
			head.previous = null;
		}
		if(current == tail) {
			tail.previous.next = null;
			tail = tail.previous;
		}
		
		
	}
	
	public void deleteAll(int element) {
		if(head == null) {
			return;
		}
		while(head != null && head.data == element) {
			head = head.next;
		}
		
		dNode current = head;
		while(current !=null) {
			if(current.data == element) {
				if(current.next == null) {
					current.previous.next = null;
					tail = current.previous;
					return;
				}
				current.previous.next = current.next;
				current.next.previous = current.previous; 
			}
			current = current.next;
		}
		
	}
	
	public boolean search(int element) throws ListIsEmpty {
		if(head == null) {
			throw new ListIsEmpty("List is empty");
		}
		dNode current = head;
		while(current != null) {
			if(current.data == element) {
				System.out.println("Element is present");
				return true;
			}
			current = current.next;
		}
		System.out.println("Element is not present");
		return false;
		
	}


	@Override
	public void print() {
		dNode current = head;
		while(current != null ) {
			System.out.print(current.data+" -> ");
			current = current.next;
		}
		
	}

}
