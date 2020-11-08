package arrays;

import java.util.HashSet;
import java.util.Set;

public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = {9,6,4,2,5,3,7,0,1}; //{2,0,1};
        int missingNumber = missingNumber_1(nums);
        System.out.println("Missing number is " + missingNumber);
        missingNumber = missingNumber_2(nums);
        System.out.println("Missing number is " + missingNumber);
    }

    private static int missingNumber_2(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }

        int n = nums.length;

        int expectedSum = n * (n + 1)/2;

        return  expectedSum - sum;
    }

    private static int missingNumber_1(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int num : nums){
            set.add(num);
        }

        for(int i = 0; i <= nums.length; i++){
            if(!set.contains(i)){
                return i;
            }
        }

        return -1;
    }


}
