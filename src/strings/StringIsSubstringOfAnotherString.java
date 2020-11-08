package strings;

public class StringIsSubstringOfAnotherString {
	
	public static void main(String[] args) {
		String s1 = "kit";
		String s2 = "Ankit Narang";
		int res = subString(s1, s2);
		
		if(res == -1)
			System.out.println("s1 " + s1 + " is not substring of s2 " + s2);
		else
			System.out.println("s1 : " + s1 + " is present in s2 " + s2 + " at index " + res);
		
	}

	private static int subString(String s1, String s2) {
		int M = s1.length();
		int N = s2.length();
		
		for(int i = 0; i <= N-M; i++) {
			int j;
			for(j = 0; j < M; j++) {
				if(s2.charAt(i+j) != s1.charAt(j)) {
					break;
				}
			}
			if(j == M)
				return i;
		}
		
		return -1;
	}

}
