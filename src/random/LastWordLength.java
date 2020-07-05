package random;

public class LastWordLength {
	
	public static void main(String[] args) {
		String str = "Hello World       ";
		System.out.println("Length of last word is " + lengthOfLastWord(str));
	}

	private static int lengthOfLastWord(String str) {
		String[] strArray = str.trim().split(" ");
		return strArray[strArray.length-1].length();
	}

}
