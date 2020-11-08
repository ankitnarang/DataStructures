package random;

public class AddBinaryStrings {
	
	public static void main(String[] args) {
		String str1 = "1011";
		String str2 = "0111";
		System.out.println("Given binary strings are : " +  str1 + " " + str2);
		String result = addBinary(str1,str2);
		System.out.println("Result " + result);
	}

	private static String addBinary(String str1, String str2) {
		StringBuilder sb = new StringBuilder();
		int i = str1.length()-1;
		int j = str2.length()-1;
		int carry = 0;
		int sum = 0;
		while(i >= 0 || j >= 0 || carry > 0) {
			int num1 = i >= 0 ? str1.charAt(i) - '0' : 0;
			int num2 = i >= 0 ? str2.charAt(i) - '0' : 0;
			sum = num1 + num2 + carry;
			sb.insert(0, sum%2);
			carry = sum/2;
			sum = 0;
			i--;
			j--;
		}
		return sb.toString();
	}

}
