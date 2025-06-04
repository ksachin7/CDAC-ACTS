package com.cdac.acts.main;

import com.cdac.acts.hashtable.Hash;
import com.cdac.acts.hashtable.HashTableUsingChaining;

public class Main {
	public static void test01(Hash ht) {
		System.out.println("*** Inserting ***");
		int[] keysToInsert = {18, 28, 38, 16, 48, 26};
		for (int key : keysToInsert) {
			ht.insert(key);
		}

		System.out.println("\n*** Searching ***");
		int[] keysToSearch = {88, keysToInsert[5], keysToInsert[0], 90};
		for (int key : keysToSearch) {
			if (ht.search(key)) {
				System.out.println(key + " found.");
			} else {
				System.out.println(key + " NOT found.");
			}
		}
	}

	public static void main(String[] args) {
		
		Hash ht = new HashTableUsingChaining();

		test01(ht);
	}

}
