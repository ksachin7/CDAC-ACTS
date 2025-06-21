package com.node;

public class LinkedlistImpl {
	Node head;
	Node tail;
	public LinkedlistImpl(){
		head=null;
		tail=null;
	}
	
	public void addAtLast(int ele) {
		Node newNode = new Node();
		newNode.data=ele;
		newNode.next=null;	
		
		if(head==null) {
			head=newNode;
			tail=newNode;
		}else {
			tail.next=newNode;
			tail=newNode;
		}
	}
	
	public void addAtFirst(int ele) {
		Node newNode=new Node();
		newNode.data=ele;
		newNode.next=null;
		
		if(head==null) {
			head = newNode;
			
		}else
		{
			newNode.next= head;
			head = newNode;
		}
	}
	
	public void deleteatFirst() {
		if (head == null) {
			return;
		}else
		{
			Node curr = head;
			head = head.next;
			curr.next= null;
			curr = null;
		}
	}
	
	public void insert(int ele) {
		Node newnode = new Node();
		newnode.data= ele;
		if(head == null) {
			head = newnode;
			
		}
		else {
			if(newnode.data <= head.data) {
				newnode.next = head;
				head = newnode;
				
			}
			else {
				Node curr = head;
				Node prev = null;
				while(curr != null) {
					if(curr.data < newnode.data) {
						prev = curr;
						curr = curr.next;	
					}
					else {
						break;
					}
				}
				newnode.next = curr;
				prev.next = newnode;				
			}
			
		}
		
		
	}
	public void deleteatLast() {
		if (head == null) {
			return;
		}
		else {
			if(head.next==null) {
				head=null;
				return;
			}
			Node curr = head;
			while(curr.next!=tail) {
				curr = curr.next;
			}
			curr.next = null;
			tail = curr;
		}
	}
	
	public void display() {
		Node curr=head;
		while(curr!=null) {
			System.out.print(curr.data+"  ");
			curr=curr.next;
		}
	}
	
	
}
