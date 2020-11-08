package arrays;


/*
 * 
 * Maximum difference between two elements such that larger element appears after the smaller number
 * Input : arr = {2, 3, 10, 6, 4, 8, 1}
 * Output : 8
 * 
 */


public class MaxDiffInArray {
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 90, 10, 110};
		//{2, 3, 10, 6, 4, 8, 1};
		System.out.println(findMax(arr)); // 109
	}

	private static int findMax(int[] arr) {
		// TODO Auto-generated method stub
		int maxDiff = arr[1] - arr[0];
		int minElem = arr[0];
		for(int i = 2 ; i < arr.length; i++) {
			if((arr[i] - minElem) > maxDiff ) {
				maxDiff = arr[i] - minElem;
			}
			if(arr[i] < minElem) {
				minElem = arr[i];
			}
		}	
		return maxDiff;
	}

}
