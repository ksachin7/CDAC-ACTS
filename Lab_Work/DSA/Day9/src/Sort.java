
public class Sort {

	public static void bubbleSort(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			for(int j=i; j<arr.length; j++) {
				if(arr[i]>arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	
	public static void insertionSort(int[] arr) {
		int sortedSize = 1;
		while(sortedSize<arr.length) {
			int elementToInsert = arr[sortedSize];
			int i = sortedSize-1;
			while(i>=0) {
				if(elementToInsert < arr[i]) {
					arr[i+1] = arr[i];
				} else {
					break;
				}
				i=i-1;
			}
			arr[i+1] = elementToInsert;
			sortedSize = sortedSize+1;
		}
	}
	
	public static boolean isArraySorted(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			for(int j=i; j<arr.length; j++) {
				if(arr[i]>arr[j]) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,6,2,5,9,0,2,4,64,647,91,674,91};
		System.out.println("Bubble Sort");
		bubbleSort(arr);
		for(int a : arr) {
			System.out.print(a + " ");
		}
		
		int[] arr1 = {1,6,2,5,9,0,2,4,64,674,91};
		System.out.println("\nInsertion Sort");
		insertionSort(arr1);
		for(int a : arr1) {
			System.out.print(a + " ");
		}
		
		int[] arr2 = {1,6,2,5,9,0,2,4,64,647,91,674,91};
		System.out.println("\n"+isArraySorted(arr2));
	}

}
