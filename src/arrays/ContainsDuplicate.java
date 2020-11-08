package arrays;

import java.util.HashMap;

public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,3};
        int k = 2;
        System.out.println("Are there any duplicates with distance " +
                "less than " + k + "? " + containsNearByDuplicate(nums,k));
    }

    private static boolean containsNearByDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length; i++){
            int current = nums[i];
            if(map.containsKey(current) && (i - map.get(current)) <= k){
                return true;
            } else {
                map.put(current,i);
            }
        }
        return false;
    }

}
