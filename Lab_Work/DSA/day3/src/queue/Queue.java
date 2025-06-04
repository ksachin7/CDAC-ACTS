package queue;

import Exception.QueueIsEmpty;
import Exception.QueueIsFull;

public interface Queue {
	
	public boolean isFull();
	
	public boolean isEmpty();
	
	public int dequeue()throws QueueIsEmpty;
	
	public void enqueue (int value)throws QueueIsFull;
}
