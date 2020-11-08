package random;

public class PalindromeString {
	
	public static void main(String[] args) {
		String str1 = "A man, a plan, a canal: Panama"; // is palindrome
		String str2 = "race a car"; // is not palindrome
		System.out.println("Given String : '" + str1 + "' is palindrome? " + isPaindrome(str1));
		System.out.println("Given String : '" + str2 + "' is palindrome? " + isPaindrome(str2));
	}

	private static boolean isPaindrome(String str) {
		int i = 0;
		int j = str.length()-1;
		char[] strArray = str.toLowerCase().toCharArray();
		while(i < j) {
			if(!(strArray[i] >= 'a' && strArray[i] <= 'z') && !(strArray[i] >= '0' && strArray[i] <= '9') ) {
				i++;
				continue;
			}
			if(!(strArray[j] >= 'a' && strArray[j] <= 'z') && !(strArray[j] >= '0' && strArray[j] <= '9') ) {
				j--;
				continue;
				
			}
			if(strArray[i] != strArray[j]) {
				return false;
			} else {
				i++;
				j--;
			}
		}
		return true;
	}

}
