package binarysearchtree;

public class Tester {

	public static void main(String[] args) {
		BSTree BST = new BSTree();
		BST.insert(10);
		BST.insert(5);
		BST.insert(20);
//		BST.insert(30);
		
		BST.print();
		System.out.println("height of the tree : "+BST.rootHeight());
//		System.out.println("Smallest of the tree : "+BST.callSmallest());
	}

}
