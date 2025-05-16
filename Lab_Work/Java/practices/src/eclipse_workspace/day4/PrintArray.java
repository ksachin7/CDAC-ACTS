package eclipse_workspace.day4;

import java.util.Arrays;

public class PrintArray {

    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void printArray(String[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        
        int[] arr = {2, 5, 6, 22, 1};
        String[] strArr = {"abc", "def", "xyz"};
        
        printArray(arr);
        printArray(strArr);
    }
}
