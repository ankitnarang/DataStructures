package arrays;

public class PeakElement {
    public static void main(String[] args) {
        int[] nums = {1,2,1,3,5,6,4};
        int index = findPeak(nums);
        System.out.println("The peak element is at index " + index + " and element is " + nums[index]);
    }

    private static int findPeak(int[] nums){

        int left = 0;
        int right = nums.length - 1;

        while (left < right){

            int mid = left + (right-left)/2;

            if(nums[mid] < nums[mid+1]){
                left = mid + 1;
            } else {
                right = mid;
            }

        }

        return left;
    }

}
