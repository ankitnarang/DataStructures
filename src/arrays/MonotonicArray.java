package arrays;

public class MonotonicArray {
    public static void main(String[] args) {
        int[] nums =  {1,1,1}; // {1,2,3,4,5,2}; //{6,5,4,4}; //{1,2,2,3};
        boolean result = isMonotonic(nums);
        System.out.println("Is array monotonic? " + result);
    }

    private static boolean isMonotonic(int[] nums){
        boolean increasing = true;
        boolean decreasing = true;

        for(int i = 0; i < nums.length-1; i++){
            if(nums[i] > nums[i+1]){
                increasing = false;
            }

            if(nums[i] < nums[i+1]){
                decreasing = false;
            }

        }

        return increasing || decreasing;
    }

}
