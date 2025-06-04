package com.cdac.acts;

public class BTTester {
	
	public static void main(String[] args) {
		BinaryTree bt1= new BinaryTree();
		
		bt1.createBT();
		
//		System.out.print("Count of nodes: ");
		bt1.countNodes();
		
//		System.out.print("Count of leaf nodes: ");
		bt1.countLeafNodes();
		
		System.out.print("\nCount nodes with value: "+bt1.CountNodesWithValue(3));

		System.out.print("\npreOrder traversal: ");
		bt1.preOrder();
		
		System.out.print("\npostOrder traversal: ");
		bt1.postOrder();
		
	}
}
