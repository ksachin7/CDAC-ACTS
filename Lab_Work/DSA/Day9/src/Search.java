
public class Search {

	public static boolean findUsingLinearSearch(int[] arr, int element) {
		for(int i=0; i<arr.length; i++) {
			if(arr[i]==element) {
				return true;
			}
		}	
		return false;
	}
	
	public static boolean findUsingBinarySearch(int[] arr, int element) {
		int low = 0;
		int high = arr.length-1;
		while(low<=high) {
			int mid = low + (high-low)/2;
			if(arr[mid]==element) {
				return true;
			}
			if(element<arr[mid]) {
				high = mid-1;
			} else {
				low = mid+1;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		System.out.println(findUsingLinearSearch(arr,10));
		System.out.println(findUsingBinarySearch(arr,17));
	}

}
