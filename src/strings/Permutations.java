package strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutations {
	
	static List<String> result = new ArrayList<>();
	
	public static void main(String[] args) {
		String str = "ANKIT";
		int len = str.length();
		permute(str,0,len);
		Collections.sort(result);
		System.out.println(result);
	}

	private static void permute(String str, int l, int r) {
		if(l == r)
			result.add(str);
		for(int i = l; i < r; i++) {
			str = swap(str,l,i);
			permute(str, l+1, r);
			str = swap(str,l,i);
		}
	}

	private static String swap(String str, int i, int j) {
		char temp;
		char[] charArray = str.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}

}
