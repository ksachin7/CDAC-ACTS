package com.cdac.acts.hashtable;

import com.cdac.acts.node.LinkedList;


public class HashTableUsingChaining implements Hash {
	private LinkedList[] buckets;
	private int size;

	public HashTableUsingChaining() {
		size = 10;
		buckets = new LinkedList[size];
		for (int i = 0; i < 10; ++i) {
			buckets[i] = new LinkedList();
		}
	}

	private int modN(int key) {
		return key % size;
	}

	@Override
	public void insert(int key) {
		int bucketId = modN(key);
		
		System.out.println("Storing key " + key + " in bucket #" + bucketId );
		buckets[bucketId].insert(key);
	}

	@Override
	public boolean search(int key) {
		int bucketId = modN(key);
		
		return buckets[bucketId].search(key);
	}

}
