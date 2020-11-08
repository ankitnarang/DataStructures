package arrays;

public class SecondSmallestElement {
	
	static int min = Integer.MAX_VALUE;
	static int secondMin = Integer.MAX_VALUE;
	
	private static void findSecondSmallestWith2Loops(int arr[]) {
		for(int i = 0 ; i < arr.length ; i++ ) {
			min = Math.min(min, arr[i]);
		}
		for(int i = 0 ; i < arr.length ; i++ ) {
			if(arr[i] > min && arr[i] < secondMin)
				secondMin = arr[i];
		}
		System.out.println("Second Minimum elem " + secondMin);
	}
	
	private static void findSecondSmallestWith1Loop(int arr[]) {
		for(int i = 0 ; i < arr.length ; i++ ) {
			if(arr[i] < min) {
				secondMin = min;
				min = arr[i];
			}
			if(arr[i] > min && arr[i] < secondMin)
			{
				secondMin = arr[i];
			}
		}
		System.out.println("Second Minimum elem " + secondMin);
	}
	
	public static void main(String[] args) {
		int[] arr = {12, 13, 2, 10, 34, 11,2};
		//Sort and take second element - // O(nlogn)
		findSecondSmallestWith1Loop(arr); // O(n)
		findSecondSmallestWith2Loops(arr); // O(n)
	}

}
