package LinkedList;

public class SinglyList implements List{
	private SLNode head;
	private SLNode tail;
	

	public SinglyList() {
		this.head = null;
		this.tail = null;
	}
	
	@Override
	public void addAtFront(int element) {
		
		SLNode newNode = new SLNode();
		newNode.data = element;
		
		if (isEmpty()) {
			head = newNode;
			tail = newNode;
			return;
		}
		
		newNode.next = head;
		head = newNode;
		
		if(tail == null) {
			tail = head;
		}
		
	}
	@Override
	public void addAtRear(int element) {
		SLNode newNode = new SLNode();
		newNode.data = element;
		newNode.next = null;
		
		if (isEmpty()) {
			head = newNode;
			tail = newNode;
			return;
		}
		
		tail.next = newNode;
		tail = newNode;	
	}
	
	@Override
	public int deleteFirstNode() {
		if(isEmpty()) {
			return 0;
		}
		SLNode temp = head;
		head = head.next;
		
		if(isEmpty()) {
			tail=head;
		}
		
		return temp.data;
		
	}
	
	@Override
	public boolean isEmpty() {
		if(head == null) {
			return true;
		}
		else
		return false;
	}
	@Override
	public void print() {
		SLNode current = head;
		
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println("");
	}
		
	
	

}
