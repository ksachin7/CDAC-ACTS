package com.cdac.acts;

class SortArray{

	void sortArray(int[] arr){

		for(int i=0; i<arr.length-1; i++){
			for(int j=0; j<arr.length-1-i; j++){
				if(arr[j]>arr[j+1]){
					int tmp= arr[j+1];
					arr[j+1]= arr[j];
					arr[j]=tmp;
				}
			}
		}

	}
	
	public static void main(String[] args) {
		int[] arr= {4, 6, 7, 1, 3};

		SortArray sort= new SortArray();
		sort.sortArray(arr);

		for(int e: arr){
			System.out.print(e+" ");
		}
		
	}

}