package recursion;

/*
 * 
 * Print numbers from 1 to given number n recursively and 
 * using tail recursion
 * 
 */

public class Print1ToN {
	
	public static void main(String[] args) {
		print(5);
		System.out.println("--------------");
		tailRecursivePrint(5,1);
	}

	private static void tailRecursivePrint(int n, int k) {
		if(n == 0)
			return;
		else {
			System.out.println(k);
			tailRecursivePrint(n-1,k+1);
		}
	}

	private static void print(int n) {
		if(n == 0)
			return;
		else {
			print(n-1);
			System.out.println(n);
		}
	}

}
