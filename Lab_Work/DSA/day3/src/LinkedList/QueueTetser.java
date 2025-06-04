package LinkedList;

import Exception.QueueIsEmpty;
import Exception.QueueIsFull;
import queue.Queue;

public class QueueTetser extends SinglyList implements Queue {
	

	@Override
	public boolean isFull() {
		return false;
	}
	
	@Override
	public boolean isEmpty() {
		return super.isEmpty();
	}

	@Override
	public int dequeue() throws QueueIsEmpty {
		return super.deleteFirstNode();
	}

	@Override
	public void enqueue(int value) throws QueueIsFull {
		super.addAtRear(value);
		
	}
	
	public void printData() {
		super.print();
	}


	public static void main(String[] args) {
		QueueTetser queue = new QueueTetser();
		try {
			queue.enqueue(1);
			queue.enqueue(2);
			queue.enqueue(3);
			queue.printData();
			
			queue.dequeue();
			queue.printData();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
