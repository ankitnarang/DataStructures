package strings;

import java.util.Arrays;

public class CheckTwoStringsAreAnagram {
	
	public static void main(String[] args) {
		String str1 = "geeks";
		String str2 = "sgeke";
		if(str1.length() != str2.length())
			System.out.println(false);
		else {
			System.out.println(check(str1,str2));
			System.out.println(checkUsingArray(str1,str2));
		}
	}
	private static boolean checkUsingArray(String str1, String str2) {
		// TODO Auto-generated method stub
		int NO_OF_CHARS = 256;
		int[] countChars = new int[NO_OF_CHARS];
		Arrays.fill(countChars, 0);
		for(int i = 0 ; i < str1.length(); i++) {
			countChars[str1.charAt(i) - 'a']++;
			countChars[str2.charAt(i) - 'a']--;
		}
		
		for(int i = 0 ; i < str1.length(); i++) {
			if(countChars[i] != 0) {
				return false;
			}
		}
		
		return true;
	}
	/*
	 * O(nlogn) + O(n)
	 */
	private static boolean check(String str1, String str2) {
		if(str1.length() != str2.length())
			return false;
		
		char[] char1 = str1.toCharArray();
		char[] char2 = str2.toCharArray();
		
		Arrays.sort(char1);
		Arrays.sort(char2);
		
		for(int i = 0 ; i < str1.length(); i++) {
			if(char1[i] != char2[i]) {
				return false;
			}
		}
		return true;
	}

}
