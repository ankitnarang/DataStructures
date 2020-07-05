package dynamicprogramming;

public class ClimbStaris {
	
	public static void main(String[] args) {
		int n = 5;
		int result = climb(n);
		System.out.println("Number of ways to climb : " + result);
	}

	private static int climb(int n) {
		
		if(n == 1)
			return 1;
		
		if (n == 2)
			return 2;
		
		int[] dp = new int[n+1];
		
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i = 3; i <= n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		return dp[n];
	}

}
