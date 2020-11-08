package dynamicprogramming;

public class HouseRobber {
    public static void main(String[] args) {
        //int[] nums = {1,2,3,1}; // O/P : 4
        int[] nums = {2,7,9,3,1}; // O/P : 12
        int result = rob(nums);
        System.out.println("Maximum amount of money collected is " + result);
    }

    private static int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);

        for(int i = 2; i < dp.length; i++){
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
        }

        return dp[nums.length-1];
    }
}
