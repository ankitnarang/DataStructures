package arrays;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int len = solve(nums);
        for(int i = 0; i < len; i++){
            System.out.print(nums[i] +  " ");
        }
    }

    private static int solve(int[] nums) {
        int index = 1;
        for(int i = 0; i < nums.length-1; i++){
           if(nums[i] != nums[i+1]){
               nums[index++] = nums[i+1];
           }
        }
        return index;
    }
}
