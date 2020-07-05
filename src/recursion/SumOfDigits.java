package recursion;

/*
 * 
 * Sum of digits of given number recursively
 * 
 */

public class SumOfDigits {
	
	public static void main(String[] args) {
		int num = 9987;
		System.out.println(sum(num));
	}

	private static int sum(int num) {
		if(num < 10)
			return num;
		return sum(num/10) + num%10;
	}

}
