package recursion;

import java.util.Comparator;

/*
 *
 * Tail recursion of Fibonacci series : 0 1 1 2 3 5 8 13 21 34 ...
 * 
 */

public class Fibonacci{
	
	public static void main(String[] args) {
		System.out.println(fibonacci(9));
		System.out.println(fibonacciTailRecursion(9, 0, 1));
	}

	private static int fibonacci(int n) {
		if(n <= 1 )
			return n;
		return fibonacci(n-1) + fibonacci(n-2);
	}

	private static int fibonacciTailRecursion(int n, int a, int b) {
		if(n == 0) {
			return a;
		}
		if(n == 1)
			return b;
		return fibonacciTailRecursion(n-1, b, a+b);
	}

}
