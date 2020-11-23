package dynamicprogramming.unboundedknapsackpattern;

public class MinimumNumberOfCoins {
    // Question Link : https://backtobackswe.com/platform/content/the-change-making-problem/solutions
    // Reference Link : https://www.youtube.com/watch?v=jgiZlGzXMBw&ab_channel=BackToBackSWE
    public static void main(String[] args) {
        int[] coins = {7,2,3,1};
        int sum = 13;
        int n = coins.length;
        int result = minimumCoins(coins,sum);
        System.out.println("Minimum number of coins needed to make sum " + sum + " is " + result);
    }

    private static int minimumCoins(int[] coins,int sum) {
        int[] dp = new int[sum+1];
        dp[0] = 0;
        for(int i = 1; i < dp.length; i++){
            dp[i] = Integer.MAX_VALUE - 1;
        }
        for(int i = 0; i < coins.length; i ++){
            for(int j = 1; j < sum + 1; j++) {
                if (coins[i] <= j) {
                    dp[j] = Math.min(dp[j],1 + dp[j - coins[i]]);
                }
            }
        }
        return dp[sum];
    }
}
