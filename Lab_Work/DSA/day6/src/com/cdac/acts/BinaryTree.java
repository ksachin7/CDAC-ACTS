package com.cdac.acts;

public class BinaryTree {
	private BTNode root;
	private int countNodes;
	private int countLeafNodes;
	private int countNodesWithValue;
	private int value;
	
	public BinaryTree(){
		root=null;
	}
	
	public void createBT() {
		BTNode n1= new BTNode(5);
		BTNode n2= new BTNode(1);
		BTNode n3= new BTNode(3);
		BTNode n4= new BTNode(2);
		BTNode n5= new BTNode(7);
		BTNode n6= new BTNode(3);
		
		root = n1;
		n1.leftChild= n2;
		n1.rightChild= n3;
		n2.leftChild= n4;
		n2.rightChild= n5;
		n3.leftChild= n6;
	}
	
	private void inOrderTraversal(BTNode root) {
		countNodes++;

		if(root == null) return;
		if(root.data == this.value) countNodesWithValue++;

		if(root.leftChild != null) {
			inOrderTraversal(root.leftChild);
		}
		else {
			if(root.rightChild == null) countLeafNodes++;
		}
		
//		System.out.print(root.data+ " ");
		
		if(root.rightChild != null) {
			inOrderTraversal(root.rightChild);
		}
	}
	
	public void countNodes() {
		inOrderTraversal(root);
		System.out.println("\nCount of nodes: "+ countNodes);
	}
	
	public void countLeafNodes() {
		countLeafNodes=0;
		inOrderTraversal(root);
		System.out.println("\nCount of leaf nodes: "+ countLeafNodes);
	}
	
	int CountNodesWithValue(int value) {
		this.value = value;
		inOrderTraversal(root);
		return countNodesWithValue;
	}
	
	private void preOrderTraversal(BTNode root) {
		if(root == null) return;
		
		System.out.print(root.data+ " ");

		if(root.leftChild != null) {
			preOrderTraversal(root.leftChild);
		}
				
		if(root.rightChild != null) {
			preOrderTraversal(root.rightChild);
		}
	}
	public void preOrder() {
		preOrderTraversal(root);
	}
	
	private void postOrderTraversal(BTNode root) {
		if(root == null) return;
		

		if(root.leftChild != null) {
			postOrderTraversal(root.leftChild);
		}
				
		if(root.rightChild != null) {
			postOrderTraversal(root.rightChild);
		}
		
		System.out.print(root.data+ " ");
	}
	
	public void postOrder() {
		postOrderTraversal(root);
	}
	
}
