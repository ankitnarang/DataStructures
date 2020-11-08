package dynamicprogramming;

public class WaysToDecode {
	
	public static void main(String[] args) {
		String str = "123";
		int result = numOfDecodings(str);
		System.out.println("Number of decodings are " + result);
	}

	private static int numOfDecodings(String str) {
		
		int len = str.length();
		
		if(str == null || len == 0)
			return 0;
		
		int dp[] = new int[len+1];
		
		dp[0] = 1;
		
		if(str.charAt(0) != '0')
			dp[1] = 1;
		
		for(int i = 2; i <= len; i++) {
			int first = Integer.parseInt(str.substring(i-1, i));
			int second = Integer.parseInt(str.substring(i-2, i));
			if(first >= 1 && first <= 9) {
				dp[i] = dp[i] + dp[i-1];
				System.out.println("first : " + first);
			}
			if(second >= 10 && second <= 26) {
				dp[i] = dp[i] + dp[i-2];
				System.out.println("second : " + second);
			}
		}
		
		return dp[len];
	}

}
