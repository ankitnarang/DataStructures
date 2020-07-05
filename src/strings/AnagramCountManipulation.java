package strings;

public class AnagramCountManipulation {
	
	private static int countCharacters(String str1, String str2) {
		int count = 0;
		if(str1.length() != str2.length())
			return 0;
		int[] charCount = new int[26];
		for(int i = 0 ; i < str1.length(); i++) {
			charCount[str1.charAt(i) - 'a']++;
		}
		for(int i = 0 ; i < str2.length(); i++) {
			if(charCount[str2.charAt(i)-'a']<=0) {
				count++;
				charCount[str2.charAt(i)-'a']--;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(countCharacters("dcek", "cfgd"));
	}
	
}
