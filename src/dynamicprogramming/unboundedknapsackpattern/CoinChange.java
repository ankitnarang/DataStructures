package dynamicprogramming.unboundedknapsackpattern;

public class CoinChange {
    // Question Link : https://www.geeksforgeeks.org/coin-change-dp-7/
    // Reference Link : https://www.youtube.com/watch?v=I4UR2T6Ro3w&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=15&ab_channel=AdityaVerma&t=1258s
    static int[][] dp;
    public static void main(String[] args) {
        int[] coins = {1,2,3};
        int sum = 5;
        int n = coins.length;
        dp = new int[n+1][sum+1];
        for(int i = 0; i < n+1; i++){
            for(int j = 0; j < sum + 1; j++){
                dp[i][j] = -1;
            }
        }
        int result = countWaysRecursive(coins,n,sum);
        System.out.println("No. of ways (Recursive) " + result);
        result = countWaysMemoization(coins,n,sum);
        System.out.println("No. of ways (Memoization) " + result);
        result = countWaysIterative(coins,n,sum);
        System.out.println("No. of ways (Iterative) " + result);
    }

    private static int countWaysIterative(int[] coins, int n, int sum) {
        int[][] table = new int[n+1][sum+1];
        for(int i = 0; i < sum + 1; i++){
            table[0][i] = 0; ;
        }
        for(int i = 1; i < n + 1; i++){
            table[i][0] = 1;
        }

        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < sum + 1; j++){
                if(coins[i-1] > j){
                    table[i][j] = table[i-1][j];
                } else  {
                    table[i][j] = table[i-1][j] + table[i][j - coins[i-1]];
                }
            }
        }

        return table[n][sum];
    }

    private static int countWaysMemoization(int[] coins, int n, int sum) {
        if(dp[n][sum] != -1){
            return dp[n][sum];
        }
        if(sum == 0){
            return 1;
        }
        if(n  ==  0){
            return 0;
        }
        if(coins[n-1] > sum){
            dp[n][sum] = countWaysMemoization(coins,n-1,sum); // dp[i][j] = dp[i-1][j]
            return dp[n][sum];
        }
        dp[n][sum] = countWaysMemoization(coins,n-1,sum) +
                countWaysMemoization(coins,n,sum - coins[n-1]);// dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
        return dp[n][sum];
    }

    private static int countWaysRecursive(int[] coins, int n, int sum) {
        if(sum == 0){
            return 1;
        }
        if(n  ==  0){
            return 0;
        }
        if(coins[n-1] > sum){
            return countWaysRecursive(coins,n-1,sum);
        }
        return countWaysRecursive(coins,n-1,sum) +
                countWaysRecursive(coins,n,sum - coins[n-1]);
    }

}
