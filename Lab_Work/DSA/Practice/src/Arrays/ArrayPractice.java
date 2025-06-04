package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ArrayPractice {

	public static void main(String[] args) {
		Integer[] arr = {4,1,2,3,5,1};
		Arrays.sort(arr);
		Set<Integer> set1 = new HashSet<>(Arrays.asList(arr));
		List<Integer> list = new ArrayList<>(set1);	
		System.out.println(list.get(arr.length-4));
		

	}

}
