package SortedList;

import LinkedList.SLNode;

public class SortedSinglyList implements SortedList{
	SLNode head;
	
	public SortedSinglyList() {
		head = null;
	}

	@Override
	public void insert(int element) {
		SLNode newNode = new SLNode();
		newNode.data = element;
		newNode.next = null;
		
		if(head == null) {
			head = newNode;
		}
		
		SLNode current = head;
		SLNode previous = null;
		
		while(current!=null) {
			if(current.data>newNode.data) {
				break;
			}
			previous = current;
			current = current.next; 
			
		}
		
		previous.next = newNode;
		newNode.next = current;
		
	}
	
	public boolean search(int element) {
		if(head == null) {
			System.out.println("List is empty");
			return false;
		}
		SLNode current = head;
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
	
	public int delete(int element){
		if(head == null) {
			System.out.println("Linked List is empty");
			return 0;
		}
		SLNode current = head;
		SLNode previous = null;
		SLNode temp = null;
		
		while(current!=null) {
			if(current.data == element) {
				break;
			}
			previous = current;
			current = current.next;
		}
		if(previous == null) {
			temp = head;
			head = head.next;
			return 0;
		}
		temp = current;
		previous.next = current.next;
		
		return temp.data;
	}
	
	public void deleteAll(int element){
		if(head == null) {
			System.out.println("Linked List is empty");
			return;
		}
		while(head != null && head.data == element) {
			head = head.next;
		}
		SLNode current = head;
		SLNode previous = null;

		while(current!=null) {
			if(current.data == element) {
				previous.next = current.next;
				current = previous;
			}
			previous = current;
			current = current.next;
		}
		
	}

	@Override
	public void print() {
		SLNode current = head;
		
		
		while(current!=null) {
			System.out.print(current.data+" ");
			current = current.next;
			
		}
		
	}

	

}
