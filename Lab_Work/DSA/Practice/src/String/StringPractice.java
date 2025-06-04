package com.acts.cdac;

import java.util.HashMap;
import java.util.Map;

public class StringPractice {

	public int firstUniqueChar(String s) {
		// Create an array to count occurrences of each character
		int[] charCount = new int[26]; // Assuming only lowercase letters a-z
		// First pass: count the occurrences of each character
		for (int i = 0; i < s.length(); i++) {
			charCount[s.charAt(i) - 'a']++; // Increment the count for the character
		}
		// Second pass: find the first non-repeating character
		for (int i = 0; i < s.length(); i++) {
			if (charCount[s.charAt(i) - 'a'] == 1) {
				return i; // Return the index of the first non-repeating character
			}
		}
		return -1; // If no non-repeating character exists
	}

	public int firstUniqChar(String s) {
		// leetcode 387
		Map<Character, Integer> charCount = new HashMap<>();

		// First pass: count the occurrences of each character
		for (int i = 0; i < s.length(); i++) {
			charCount.put(s.charAt(i), charCount.getOrDefault(s.charAt(i), 0) + 1);
		}

		// Second pass: find the first non-repeating character
		for (int i = 0; i < s.length(); i++) {
			if (charCount.get(s.charAt(i)) == 1) {
				return i; // Return the index of the first non-repeating character
			}
		}

		return -1; // If no non-repeating character exists
	}

	public static void main(String[] args) {
		StringPractice solution = new StringPractice();
		String s1 = "leetcode";
		System.out.println(solution.firstUniqChar(s1)); // Output: 0
		System.out.println(solution.firstUniqueChar(s1)); // Output: 0

		String s2 = "loveleetcode";
		System.out.println(solution.firstUniqChar(s2)); // Output: 2
		System.out.println(solution.firstUniqueChar(s2)); // Output: 2

		String s3 = "aabb";
		System.out.println(solution.firstUniqChar(s3)); // Output: -1
		System.out.println(solution.firstUniqueChar(s3)); // Output: -1
	}
}
 class StringProblems {

    // 1. Reverse a String
    public static String reverseString(String s) {
        char[] arr = s.toCharArray();
        int left = 0, right = arr.length - 1;
        while (left < right) {
            char temp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = temp;
        }
        return new String(arr);
    }

    // 2. Check for Anagrams
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int c : count) {
            if (c != 0) return false;
        }
        return true;
    }

    // 3. Longest Substring Without Repeating Characters
    public static int lengthOfLongestSubstring(String s) {
        int[] lastIndex = new int[128]; // ASCII size
        int maxLen = 0, start = 0;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            start = Math.max(lastIndex[c], start);
            maxLen = Math.max(maxLen, i - start + 1);
            lastIndex[c] = i + 1;
        }
        return maxLen;
    }

    // 4. Palindrome Check
    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() -1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }

    // 5. Count and Say
    public static String countAndSay(int n) {
        if (n == 1) return "1";
        String prev = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i=1; i<prev.length(); i++) {
            if (prev.charAt(i) == prev.charAt(i-1)) {
                count++;
            } else {
                sb.append(count);
                sb.append(prev.charAt(i-1));
                count = 1;
            }
        }
        sb.append(count);
        sb.append(prev.charAt(prev.length() - 1));
        return sb.toString();
    }

    // 6. Valid Parentheses
    public static boolean isValidParentheses(String s) {
        java.util.Stack<Character> stack = new java.util.Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c) return false;
        }
        return stack.isEmpty();
    }

    // 7. String Compression
    public static String compressString(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i=0; i<s.length(); i++) {
            if (i+1 < s.length() && s.charAt(i) == s.charAt(i+1)) {
                count++;
            } else {
                sb.append(s.charAt(i));
                sb.append(count);
                count = 1;
            }
        }
        String compressed = sb.toString();
        return compressed.length() < s.length() ? compressed : s;
    }

    // 8. Rotate String
    public static boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        String concat = s + s;
        return concat.contains(goal);
    }

    // 9. Find All Anagrams in a String
    public static java.util.List<Integer> findAnagrams(String s, String p) {
        java.util.List<Integer> res = new java.util.ArrayList<>();
        if (s.length() < p.length()) return res;

        int[] pCount = new int[26];
        int[] sCount = new int[26];
        for (int i=0; i<p.length(); i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }
        if (java.util.Arrays.equals(pCount, sCount)) res.add(0);

        for (int i=p.length(); i<s.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
            sCount[s.charAt(i - p.length()) - 'a']--;
            if (java.util.Arrays.equals(pCount, sCount)) {
                res.add(i - p.length() + 1);
            }
        }
        return res;
    }

    // 10. Group Anagrams
    public static java.util.List<java.util.List<String>> groupAnagrams(String[] strs) {
        java.util.Map<String, java.util.List<String>> map = new java.util.HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            java.util.Arrays.sort(arr);
            String key = new String(arr);
            map.computeIfAbsent(key, k -> new java.util.ArrayList<>()).add(str);
        }
        return new java.util.ArrayList<>(map.values());
    }

}

