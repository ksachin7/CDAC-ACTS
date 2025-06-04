package day1;

import java.util.Arrays;
import java.util.Scanner;

public class DeleteFromArray {
	
	public static int deleteByPosition(int arr[],int size, int position) {
		if(position<0 || position >=size) {
			System.out.println("Index Out of bound");
			return size;
		}
		else {
			for(int i=position;i<size-1;i++) {
				arr[i] = arr[i+1];
			}
			return size-1;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = {1,2,3,4,5};
		
		System.out.println("Original Array: "+Arrays.toString(arr));
		
		System.out.println("Enter position of element you want to delete");
		int position = sc.nextInt();
		
		int newLength = deleteByPosition(arr,arr.length,position);
		
		for(int i = 0;i<newLength;i++) {
			System.out.print(arr[i]+" ");
		}

	}

}
