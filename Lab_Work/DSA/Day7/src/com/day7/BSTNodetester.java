package com.day7;

public class BSTNodetester {
	public static void testBST() {
		BinarySearchTree bst1= new BinarySearchTree();
		int[] valuesToInsert = {10, 5, 8,20, 15, 30, 1, 12};

		for (int value : valuesToInsert) {
			bst1.insert(value);
		}
		bst1.inOrder();
		bst1.height();
		System.out.println("Smallest Value:");
		bst1.findSmallest();
		System.out.println("Largest Value:");
		bst1.findLargest();
		bst1.deleteNode(1);
		System.out.println("Deleting leaf node");
		bst1.inOrder();
		
		System.out.println("Deleting node with one child");
		bst1.deleteNode(5);
		bst1.inOrder();
		System.out.println("Deleting node with 2 child");
		bst1.deleteNode(20);
		bst1.inOrder();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testBST();
		
	}

}
