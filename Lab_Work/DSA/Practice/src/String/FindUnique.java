package String;

import java.util.Arrays;

public class FindUnique {
	public static void uniquElement(String str) {
		char strchar[] = str.toCharArray();
		int alphabet[] = new int[26];
		Arrays.fill(alphabet, 0);

		for (int i = 0; i < str.length(); i++) {
			alphabet[strchar[i] - 'a']++;
		}

		for (int i = 0; i < str.length(); i++) {
			if (alphabet[strchar[i] - 'a'] == 1) {
				System.out.println(strchar[i]);
				break;
			}
		}
	}

	public static void main(String[] args) {
		String str = "abcda";

		for (int i = 0; i < str.length(); i++) {
			boolean isUnique = true;

			for (int j = 0; j < str.length(); j++) {
				if (i != j && str.charAt(i) == str.charAt(j)) {
					isUnique = false;
					break;
				}
			}
			if (isUnique) {
				System.out.println(str.charAt(i));
				break;
			}
		}
	}

}
