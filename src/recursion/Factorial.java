package recursion;

/*
 * 
 * Recursive factorial method 
 * and 
 * tail recursive factorial method
 * 
 */

public class Factorial {
	
	public static void main(String[] args) {
		System.out.println(fact(4));
		System.out.println(tailRecursiveFact(4,1));
	}

	private static int tailRecursiveFact(int n, int val) {
		if(n == 1)
			return val;
		else
			return tailRecursiveFact(n-1, n * val);
	}

	private static int fact(int n) {
		if(n == 1)
			return 1;
		else
			return n * fact(n-1);
	}
	

}
