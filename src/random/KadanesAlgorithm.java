package random;

public class KadanesAlgorithm {
	
	public static void main(String[] args) {
		int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
		int maxSum = maxSumSubarray(arr);
		System.out.println("Value of max is " + maxSum);
		printMaxSumSubarray(arr);
	}

	private static int maxSumSubarray(int[] arr) {
		int currSum = 0;
		int maxSum = Integer.MIN_VALUE;
		for(int i = 0 ; i < arr.length; i++) {
			currSum += arr[i];
			maxSum = Math.max(currSum, maxSum);
			if(currSum < 0)
				currSum = 0;
		}
		return maxSum;
	}
	
	private static void printMaxSumSubarray(int[] arr) {
		int currSum = 0;
		int maxSum = Integer.MIN_VALUE;
		int start = 0, s = 0, end = 0;
		for(int i = 0 ; i < arr.length; i++) {
			currSum += arr[i];
			if(maxSum < currSum) {
				maxSum = currSum;
				start = s;
				end = i;
			}
			if(currSum < 0) {
				currSum = 0;
				s = i + 1;
			}
		}
		System.out.print("Values of sub array with max sum are ");
		for(int i = start; i <= end; i++) {
			System.out.print(arr[i] + " ");
		}
		
	}
	
	

}
