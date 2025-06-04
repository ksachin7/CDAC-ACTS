package day8;

import java.util.Arrays;
import java.util.Scanner;

public class  SearchOperations{
	
	static boolean findUsingLinearSearch(int[] arr, int element) {
		for(int i=0;i<arr.length;i++) {
			if(arr[i] == element) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean findUsingBinarySearch(int arr[],int element) {
		int low = 0;
		int high = arr.length;
		
		
		while(low < high) {
			int mid = low + (low + high)/2;
			if(mid == element) {
				return true;
			}
			if(element < arr[mid]) {
				high = mid - 1;
			}
			if(element > arr[mid]) {
				low = mid + 1;
			}
		}
		return false;
	}

	


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = {1,2,3,4,5,6};
		System.out.println(Arrays.toString(arr));
		System.out.println("Enter element to find");
		int ele = sc.nextInt();
		System.out.println("Found using linear serch : "+findUsingLinearSearch(arr,ele));
		
		System.out.println("Found using Binary serch : "+findUsingBinarySearch(arr,ele));
		
		

	}

}
