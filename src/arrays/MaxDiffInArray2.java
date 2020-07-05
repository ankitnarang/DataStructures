package arrays;


/*
 * 
 * Maximum difference between two elements such that larger element appears before the smaller number
 * Input : arr = {2, 3, 10, 6, 4, 8, 1}
 * Output : 9
 * 
 */


public class MaxDiffInArray2 {
	
	public static void main(String[] args) {
		int[] arr = {2, 3, 10, 6, 4, 8, 1};
		System.out.println(findMax(arr));
	}

	private static int findMax(int[] arr) {
		// TODO Auto-generated method stub
		int maxDiff = arr[1] - arr[0];
		int maxElem = arr[0];
		for(int i = 2 ; i < arr.length; i++) {
			if(arr[i] < maxElem) {
				if((maxElem - arr[i]) > maxDiff) {
					maxDiff = maxElem - arr[i];
				}
			}
			if(arr[i] > maxElem)
				maxElem = arr[i];
		}	
		return maxDiff;
	}

}
