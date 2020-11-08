package arrays;

public class SortZeroesOnesTwos {
	
	public static void main(String[] args) {
		int arr[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
		System.out.println("Before Sorting :");
		for (int value : arr) {
			System.out.print(value + " ");
		}
		System.out.println("\nAfter Sorting :");
		sort012(arr);
	}

	private static void sort012(int[] arr) {
		int low = 0;
		int mid = 0;
		int high = arr.length-1;
		int temp = -1;
		while(mid <= high) {
			if(arr[mid] == 0) {
				temp = arr[mid];
				arr[mid] = arr[low];
				arr[low] = temp;
				low++;
				mid++;
			} else if(arr[mid] == 1) {
				mid++;
			} else {
				temp = arr[mid];
				arr[mid] = arr[high];
				arr[high] = temp;
				high--;
			}
		}
		for(int i = 0 ; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
	}

}
