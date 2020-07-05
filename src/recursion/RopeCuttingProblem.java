package recursion;

/*
 * 
 * Given a rope of length n, you need to find maximum number of pieces you can make such that length of every piece is 
 * in set {a,b,c}. If no possible output then return -1.
 * Example 	n = 5 , a = 2, b = 5, c = 1 O/P : 5 
 * 			n = 23 , a = 12, b = 9, c = 11 O/P : 2
 * 			n = 5 , a = 4, b = 2, c = 6 O/P : -1
 */

public class RopeCuttingProblem {
	
	public static void main(String[] args) {
		int n = 5;
		int a = 4;
		int b = 2;
		int c = 6;
		System.out.println(solve(n,a,b,c));
	}

	private static int solve(int n, int a, int b, int c) {
		if(n == 0)
			return 0;
		if(n < 0)
			return -1;
		int res = Math.max(solve(n-a, a, b, c), Math.max(solve(n-b, a, b, c), solve(n-c, a, b, c)));
		if(res == -1) 
			return -1;
		return res + 1;
	}

}
