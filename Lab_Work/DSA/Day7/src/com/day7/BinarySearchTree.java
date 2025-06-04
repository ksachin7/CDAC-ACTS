package com.day7;



public class BinarySearchTree {
	BSTNode root;
	int leafCount;
	public BinarySearchTree() {
		root =null;
	}
	public void insert(int element) {
		BSTNode newNode= new BSTNode(element);
		if(root==null) {
			root=newNode;
			return;
		}
		BSTNode curNode = root;
		while(curNode!=null) {
			if(element < curNode.data) {
				if(curNode.leftChild==null) {
					curNode.leftChild=newNode;
					return;
				}
				curNode=curNode.leftChild;
			}else {
				if(curNode.rightChild==null) {
					curNode.rightChild=newNode;
					return;
				}
				curNode=curNode.rightChild;
			}
			
		}
	}
	private void inOrder(BSTNode root)
	{
//		++functionCount;
		if(root==null) {
			return;
		}
		if(root.leftChild!=null)
		{
			inOrder(root.leftChild);
		}
		System.out.print(root.data+" ");
		if(root.rightChild!=null)
		{
			inOrder(root.rightChild);
		}
	}
	public void inOrder() {
//		 functionCount= 0;
		System.out.println("InOrder: ");
		inOrder(root);
		
	}

	private  int height(BSTNode root) {
		if(root==null) {
			return 0;
		}
		if(root.leftChild==null && root.rightChild==null)
		{
			return 0;
		}
//		System.out.println(height(root.rightChild));
		return 1 + Math.max(height(root.leftChild),height(root.rightChild));
	}
	public void height() {
	int height1=height(root);
	System.out.println();
	System.out.println(height1);
	}
	public void findSmallest() {
		BSTNode curNode = root;
		while(curNode.leftChild!=null) {
			curNode=curNode.leftChild;
		}
		System.out.println(curNode.data);
	}
	public void findLargest() {
		BSTNode curNode = root;
		while(curNode.rightChild!=null) {
			curNode=curNode.rightChild;
		}
		System.out.println(curNode.data);
	}
	public void deleteNode(int element) {
		BSTNode parent= null;
		BSTNode current= root;
		while(current!=null) {
			if(current.data==element) {
				break;
			}
			parent=current;
			if(current.data > element) {
//				parent=current;
				current= current.leftChild;
			}
			else {	
				current= current.rightChild;
			}
		}
		// Is an element found?
		if(current==null) {
			System.out.println("Element  not found");
			return;
		}
		
		// Deleting leaf node?
		if(current.leftChild==null && current.rightChild==null) {
			if(current==root) {
				root=null;
			}
			else if(current==parent.leftChild) {
				parent.leftChild=null;
			}
			else{
				parent.rightChild=null;
			}
		}
		// Deleting node with only one child?
		 else if (current.leftChild == null || current.rightChild == null) {
		        BSTNode childOfCurrent = (current.leftChild != null) ? current.leftChild : current.rightChild;

		        if (current == root) {
		            root = childOfCurrent; // Update root if necessary
		        } else if (current == parent.leftChild) {
		            parent.leftChild = childOfCurrent;
		        } else {
		            parent.rightChild = childOfCurrent;
		        }
		    }
		 else {
		BSTNode ios = current.rightChild;
		BSTNode iosParent = current;
		while(ios.leftChild!=null) {
			iosParent=ios;
			ios= ios.leftChild;
		}
		current.data=ios.data;
		if(iosParent.leftChild==ios) {
		iosParent.leftChild=ios.rightChild;
		}
		else {
			iosParent.rightChild=ios.rightChild;
		}
		 }
	}
}

















