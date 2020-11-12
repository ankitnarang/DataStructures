package dynamicprogramming.knapsack01pattern;

public class TargetSum {
    //Question Link : https://leetcode.com/problems/target-sum/
    //Reference link : https://www.youtube.com/watch?v=Hw6Ygp3JBYw&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=12&ab_channel=AdityaVerma
    /*
        Intuition :
        Given array = {1, 1, 1, 1, 1}
        Given Diff = 3;
        Possible Outputs :
        -1+1+1+1+1 = 3
        +1-1+1+1+1 = 3
        +1+1-1+1+1 = 3
        +1+1+1-1+1 = 3
        +1+1+1+1-1 = 3

        We have to make 2 subsets S1 and S2 and their difference should be given diff.
        The problem is reduced to problem : Find count of subsets sum with difference equal to given difference
        CountMinimumDifferenceOfSubsets

     */
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int diff = 3;
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        int subsetSum = (sum + diff)/2;
        int result = countSubsetSum(nums,subsetSum,nums.length);
        System.out.println("No of subsets sum with given difference is " + result);
    }

    private static int countSubsetSum(int[] nums, int sum, int n) {
        if(sum == 0){
            return 1;
        }
        if(n == 0){
            return 0;
        }
        if(nums[n-1] > sum) {
            return countSubsetSum(nums,sum,n-1);
        } else {
            return countSubsetSum(nums,sum,n-1) +
                    countSubsetSum(nums,sum - nums[n-1],n-1);
        }
    }

}
