package day8;

import java.util.Arrays;

public class SortingAlgo {
	
	public static void bubbleSort(int[] arr) {
		for(int i=0;i<arr.length-1;i++) {
			int isSwaped = 0;
			for(int j=0;j<arr.length-1;j++) {
				if(arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					isSwaped = 1;
				}
			}
			if(isSwaped == 0) {
				System.out.println("Already sorted");
				return;
			}
		}
	}
	
	public static void selectionSort(int []arr) {
		for(int i = 0;i<arr.length-1;i++) {
			int min_index = i;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[min_index] > arr[j]) {
					min_index = j;
				}
			}
			int temp = arr[min_index];
			arr[min_index] = arr[i];
			arr[i] = temp;
		}
	}
	
	public static void insertionSort(int []arr) {
		for(int i = 1; i<arr.length;i++) {
			int j=i-1;
			int key = arr[i];
			while(j >= 0 && arr[j] > key) {
				arr[j+1] = arr[j];
				j = j - 1;
			}
			arr[j+1] = key;
		}
	}
	
	public static boolean isArraySorted(int[] arr) {
		for(int i=0;i<arr.length-1;i++) {
			if(arr[i] > arr[i+1]) {
				return false;
			}
		}
		return true;
	}
	

	public static void main(String[] args) {
		int arr[] = {5,2,9,11,5,1};
		System.out.println(Arrays.toString(arr));
//		bubbleSort(arr);
//		selectionSort(arr);
		insertionSort(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println(isArraySorted(arr));
	}

}
