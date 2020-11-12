package dynamicprogramming.knapsack01pattern;


import java.util.HashMap;

public class PartitionEqualSubSets {
    // Question Link : https://www.geeksforgeeks.org/partition-problem-dp-18/
    // Good Reference : https://www.youtube.com/watch?v=UmMh7xp07kY&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=8&ab_channel=AdityaVerma
    public static void main(String[] args) {
        int[] nums = {1,5,11,5}; //{1,2,3,5};
        boolean result = canPartition(nums);
        System.out.println("Can this set be divided into equal subsets? " + result);
        result = canPartitionII(nums);
        System.out.println("Can this set be divided into equal subsets? " + result);
    }

    private static boolean canPartitionII(int[] nums) {
        int sum = 0;

        for(int num : nums){
            sum += num;
        }

        if(sum % 2 != 0){
            return false;
        }

        return isSubsetSum(nums,nums.length,sum/2);
    }

    private static boolean isSubsetSum(int[] nums, int n, int sum){
        if(sum == 0){
            return true;
        }

        if(n == 0){
            return false;
        }

        if(nums[n-1] > sum){
            return isSubsetSum(nums,n-1,sum);
        } else {
            return isSubsetSum(nums,n-1,sum) ||
                    isSubsetSum(nums,n-1,sum - nums[n-1]);
        }

    }

    private static boolean canPartition(int[] nums) {
        int total = 0;
        for(int num : nums){
            total += num;
        }
        //If sum of array is odd, array can never be divided into equal subsets
        if(total%2 != 0){
            return false;
        }

        return canPartition(nums,0,0,total, new HashMap<String,Boolean>());
    }

    private static boolean canPartition(int[] nums, int index, int sum, int total,
                                        HashMap<String, Boolean> state) {
        String current = index + "" + sum;
        if(state.containsKey(current)){
            return state.get(current);
        }
        if(sum * 2 == total){
            return true;
        }
        if(sum > total/2 || index >= nums.length){
            return false;
        }

        boolean foundPartition = canPartition(nums,index + 1,sum,total,state)
                || canPartition(nums,index + 1, sum + nums[index], total,state);
        state.put(current,foundPartition);
        return foundPartition;
    }

}
