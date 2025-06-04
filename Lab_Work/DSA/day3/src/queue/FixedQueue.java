package queue;

import java.util.Scanner;

import Exception.QueueIsEmpty;
import Exception.QueueIsFull;


public class FixedQueue implements Queue {
	public static int front=0;
	public static int rear=-1;
	public static int capacity=3;
	public static int arr[]= new int[capacity]; 
	

	public FixedQueue() {
		super();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
	}

	@Override
	public boolean isFull() {
		return rear == capacity-1;
	}

	@Override
	public boolean isEmpty() {
		return front == rear+1;
	}

	@Override
	public int dequeue() throws QueueIsEmpty {
		if(isEmpty()) {
			throw new QueueIsEmpty("Queue is empty cannot remove");
		}
		else {
			int item = arr[front++];
			System.out.println(item);
			return item;
		}
		
	}

	@Override
	public void enqueue(int value) throws QueueIsFull{
		if(isFull()) {
			throw new QueueIsFull("Queue is full cannot add elements");
		}
		else{
			arr[++rear] = value;
		}
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		FixedQueue f = new FixedQueue();
		
		int choice = 0;
		
		while(choice !=4) {
			System.out.println(""
					+ "\n1.Add to Queue"
					+ "\n2.Remove from queue"
					+ "\n3.Display Queue"
					+ "\n4.Exit");
			choice = sc.nextInt();
			switch(choice) {
			case 1:{
				System.out.println("Enter element to add");
				int ele = sc.nextInt();
				try {
					f.enqueue(ele);
				} catch (QueueIsFull e) {
					e.printStackTrace();
				}
				break;
			}
			case 2:{
				try {
					f.dequeue();
				} catch (QueueIsEmpty e) {
					e.printStackTrace();
				}
				break;
			}
			case 3:{
				for(int i=front;i<=rear;i++) {
					System.out.print(arr[i]+" ");
				}
				break;
			}
			}
		}
		
		sc.close();

	}

}
