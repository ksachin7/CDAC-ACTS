package binarysearchtree;

public class BSTree {
	BNode root;

	public BSTree() {
		System.out.println("tree created");
		this.root = null;
	}

	public void insert(int val) {
		BNode newNode = new BNode();
		newNode.data = val;
		newNode.leftChild = null;
		newNode.rightChild = null;

		if(root == null) {
			root = newNode;
			return;
		}

		BNode current = root; 
		while(current != null) {
			if(val < current.data) {
				if(current.leftChild == null) {
					current.leftChild = newNode;
					return;
				}
				current = current.leftChild;
			}

			if(val > current.data) {
				if(current.rightChild == null) {
					current.rightChild = newNode;
					return;
				}
				current = current.rightChild;
			}
		}
	}

	public int rootHeight() {
		return height(root);
	}
	
	
	public int height(BNode root) {
		if(root == null) {
			return -1;
		}
		else{
			int left = height(root.leftChild);
			int right = height(root.rightChild);
			return 1 + Math.max(left,right);
		}
	}
	
	public void callSmallest() {
		System.out.println(findSmallest(root));
	}

	public int findSmallest(BNode root) {
		if(root == null) {
			return 0;
		}
		return findSmallest(root.leftChild);
		
	}
	
	public void print() {
		inOrder(root);
	}

	public void inOrder(BNode node) {

		if(node==null) {
			return;
		}
		if (node != null) {
			inOrder(node.leftChild);
			System.out.println(node.data);
			inOrder(node.rightChild);
		}
	}
}
