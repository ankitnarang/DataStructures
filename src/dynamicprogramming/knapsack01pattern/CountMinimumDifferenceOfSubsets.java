package dynamicprogramming.knapsack01pattern;

public class CountMinimumDifferenceOfSubsets {
    //Reference link : https://www.youtube.com/watch?v=ot_XBHyqpFc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=11&ab_channel=AdityaVerma
    /*
        Intuition :
        Take arr = {1,1,2,3};
        Given Diff = 1;
        sum = sum of all elements of arr i.e 7
        so sum = 7
        To find : no of subsets with given diff : S1 - S2 = diff
        No S1 + S2 = sum
        Adding above 2 equations, 2 * S1 = sum + diff
        S1 = (sum + diff) / 2
        S1 = (7 + 1)/ 2 = 4
        Problem now reduced to : Find subset with sum 4
        Output of given array {1,1,2,3} is 3
        The 3 subsets are {1,2} & {1,3}; {1,2} & {1,3}; {1,1,2} & {3}
     */
    public static void main(String[] args) {
        int[] nums = {1,1,2,3};
        int diff = 1;
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
