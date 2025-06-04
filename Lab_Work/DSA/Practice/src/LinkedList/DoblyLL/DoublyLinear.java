package LinkedList.DoblyLL;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class DoublyLinear {
	public static Node head;
	public static Node tail;
	
	public DoublyLinear() {
		this.head = null;
		this.tail = null;
	}
	
	public static void countOcc() {
		Map<Integer,Integer> freq = new LinkedHashMap<>();	
		Node current = head;
		while(current != null) {
			freq.put(current.data, freq.getOrDefault(current.data, 0)+1);
			current = current.next;
		}
		for(Map.Entry<Integer, Integer> entry:freq.entrySet()) {
			System.out.println(entry.getKey()+" : "+entry.getValue());
		}
	}
	
	public static void addAtLast(int element) {
		
		Node newNode = new Node();
		newNode.data = element;
		if(head == null) {
			head = newNode;
			tail = newNode;
			return;
		}
		tail.next = newNode;
		newNode.prev = tail;
		tail = newNode;
	}
	
	public static void addAtFront(int element) {
		Node newNode = new Node();
		newNode.data = element;
		
		if(head == null) {
			head = newNode;
			tail = newNode;
			return;
		}
		
		newNode.next = head;
		head.prev = newNode;
		head = newNode;
	}
	
	public static void RemoveAtLast() {
		if(head == null) {
			return;
		}
		if(head == tail) {
			head = null;
			tail = null;
			return;
		}
		tail = tail.prev;
		tail.next = null;
		
	}
	
	public static void deleteElement(int element) {
		if(head == null) {
			return;
		}
		if(head == tail) {
			head = null;
		}
		while(head !=null && head.data == element) {
			head = head.next;
		}
		if(tail !=null && tail.data == element) {
			tail = tail.prev;
			tail.next = null;
		}
		
		Node current = head;
		while(current != null) {
			if(current.data == element) {
				current.prev.next = current.next;
				current.next.prev = current.prev;
			}
			current = current.next;
		}
	}
	
	public static void RemoveFront() {
		if(head == null) {
			return;
		}
		if(head == tail) {
			head = null;
			tail = null;
			return;
		}
		head = head.next;
	}
	
	public static void display() {
		Node current = head;
		while(current != null) {
			System.out.print(current.data+" ");
			current = current.next;
		}
		System.out.println(" ");
	}

	public static void main(String[] args) {
		
		DoublyLinear dl = new DoublyLinear();
		
		dl.addAtLast(1);
		dl.addAtLast(2);
		dl.addAtLast(3);
		dl.addAtLast(2);
		dl.addAtLast(1);
//		dl.addAtFront(0);
		
		dl.display();
		
		countOcc();
//		
//		dl.RemoveAtLast();
//		dl.display(); 
//		
//		dl.RemoveFront();
//		dl.display();
		
//		dl.deleteElement(1);
//		dl.display();
		
		 

	}

}
