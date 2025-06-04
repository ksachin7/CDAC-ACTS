package com.cdac.acts;

public class BTNode {
	BTNode leftChild;
	BTNode rightChild;
	int data;
	
	public BTNode() {	}

	BTNode(int data){
		this.data= data;
		leftChild= null;
		rightChild= null;
	}
}
