package arrays;

/*
    Given array and sum
    Find the smallest subarray with sum greater than given sum
 */
public class SmallestSubarrayWithSum {

    public static void main(String[] args) {
        int[] array = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250}; // {1, 4, 45, 6, 0, 19}; //{1, 10, 5, 2, 7};
        int sum = 280; //51; //9;
        System.out.println("The length of smallest sub array is " + minSubArrayLen(array,sum));
    }

    private static int minSubArrayLen(int[] array, int sum) {
        int minLen = Integer.MAX_VALUE;
        int currSum = 0;
        int start = 0;
        int end = 0;
        int n = array.length;

        while (end < array.length){
            while (currSum <= sum && end < n){
                currSum += array[end];
                end++;
            }
            while (currSum > sum && start < n){
                minLen = Math.min(minLen,end - start);
                currSum -= array[start];
                start++;
            }
        }
        return minLen;
    }

}
