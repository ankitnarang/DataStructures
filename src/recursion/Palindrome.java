package recursion;

/*
 * 
 * Check if given String is palindrome recursively 
 * 
 */

public class Palindrome {
	
	public static void main(String[] args) {
		String str = "abcba";
		System.out.println(isPalindrome(str,0,str.length()-1));
	}

	private static boolean isPalindrome(String str, int start, int end) {
		if(start == end || start > end)
			return true;
		if (str.charAt(start) != str.charAt(end))
			return false;
		return isPalindrome(str, start + 1, end - 1);
	}

}
