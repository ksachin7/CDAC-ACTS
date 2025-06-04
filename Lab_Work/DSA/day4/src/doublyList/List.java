package doublyList;

import Exception.ListIsEmpty;

public interface List {
	void addAtFront(int element);
	void addAtRear(int element);
	int deleteFirstNode() throws ListIsEmpty;
	boolean isEmpty();
	void print();

}