package binarysearch;

public class AlternativePostiveAndNegative {
	
	private static void solve(int[] arr) {
		int wrongIndex = -1;
		for(int i = 0 ; i < arr.length ; i++ ) {
			if(wrongIndex >= 0) {
				if( (arr[i] >= 0 && arr[wrongIndex] < 0) || (arr[i] < 0 && arr[wrongIndex] >= 0) ) {
					rotate(arr, wrongIndex, i);
					if(i - wrongIndex > 2) {
						wrongIndex += 2;
					} else
						wrongIndex = -1;
				}
			}
			if(wrongIndex == -1) {
				if( (arr[i] < 0 && i%2 == 1) || (arr[i] > 0 && i%2 == 0) ) {
					wrongIndex = i;
				}
			}
		}
		System.out.println();
		System.out.print("After rearrangement, Array : ");
		for(int i = 0 ;i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	private static void rotate(int[] arr, int wrongIndex, int currentIndex) {
		int temp = arr[currentIndex];
		int i = currentIndex;
		for(i = currentIndex; i > wrongIndex; i--) {
			arr[i] = arr[i-1];
		}
		arr[i] = temp;
	}
	
	public static void main(String[] args) {
		int[] arr = {-1, -2, -3, 4, 5};
		System.out.print("Before rearrangement, Array : ");
		for(int i = 0 ;i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		solve(arr);
	}

}
