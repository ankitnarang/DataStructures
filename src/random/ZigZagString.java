package random;

import java.util.Arrays;

public class ZigZagString {

	public static void main(String[] args) {
		String str = "PAYPALISHIRING";
		System.out.println("Given String is " + str);
		int numOfRows = 3;
		String result = convert(str,numOfRows);
		System.out.println("Result string is " + result);
	}

	private static String convert(String str, int numOfRows) {
		if(numOfRows == 0 || numOfRows == 1)
			return str;
		
		int len = str.length();
		String[] arr = new String[numOfRows];
		Arrays.fill(arr, "");
		boolean down = true;
		char[] strArray = str.toCharArray();
		int row = 0;
		for(int i = 0 ; i < len; i++) {
			arr[row] += strArray[i];
			if(row == numOfRows - 1)
				down = false;
			if(row == 0)
				down = true;
			if(down == true)
				row++;
			if (down == false)
				row--;
		}
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
		}
		return sb.toString();
	}

}
