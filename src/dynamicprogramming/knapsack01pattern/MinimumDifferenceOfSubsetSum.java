package dynamicprogramming.knapsack01pattern;

public class MinimumDifferenceOfSubsetSum {
    // Question Link : https://www.geeksforgeeks.org/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum/
    // Good Reference : https://www.youtube.com/watch?v=-GtpxG6l_Mc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=10&ab_channel=AdityaVerma&t=1s
    public static void main(String[] args) {
        int[] nums = {1,2,7}; //{1,6,11,5};
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        boolean[][] result = subsetSum(nums,sum,nums.length);

        int[] lastColumn = new int[sum+1];
        int index = 0;
        for(int i = 1; i < (sum+1)/2; i++){
            if(result[i][nums.length] == true){
                lastColumn[index] = i;
                index++;
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < index; i++){
            min = Math.min(min,sum - 2 * lastColumn[i]);
        }
        System.out.println("The minimum difference between subset sum is " + min);
    }

    private static boolean[][] subsetSum(int[] nums, int sum, int n) {
        boolean[][] dp = new boolean[sum+1][n+1];

        for(int i = 0; i < n+1; i++){
            dp[0][i] = true;
        }

        for(int i = 1; i < sum+1; i++){
            dp[i][0] = false;
        }

        for(int i = 1; i < sum+1; i++){
            for(int j = 1; j < n+1; j++){
                if(nums[j-1] <= i){
                    dp[i][j] = dp[i][j-1] || dp[i-nums[j-1]][j-1];
                } else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }

        return dp;
    }
}
