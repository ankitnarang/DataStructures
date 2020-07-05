package greedyalgorithms;

public class MinimumNumberOfPlatforms {
	
	
	public static void main(String[] args) {
		int arr[] = {900, 940, 950, 1100, 1500, 1800};
		int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
		System.out.println("Minimum No. of Platforms required " + findPlatform(arr,dep));
	}

	private static int findPlatform(int[] arr, int[] dep) {
		int platformNeeded = 1;
		int result = 1;
		int i = 1, j = 0;
		int len = arr.length;
		while(i < len && j < len) {
			if(arr[i] <= dep[j]) {
				platformNeeded++;
				i++;
				if(platformNeeded > result)
					result = platformNeeded;
			} else {
				platformNeeded--;
				j++;
			}
			
		}
		return result;
	}

}
