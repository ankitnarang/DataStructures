package dynamicprogramming;

public class ClimbStairs {
	
	public static void main(String[] args) {
		int n = 10;
		int result = climb(n);
		System.out.println("Number of ways to climb : " + result);
		System.out.println("Number of ways to climb (recursive solution) : " + climb_recursive(n));
	}

	private static int climb_recursive(int n){
		if(n <= 1){
			return 1;
		}
		return climb_recursive(n-2) + climb_recursive(n-1);
	}

	private static int climb(int n) {

		if(n <= 1)
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
