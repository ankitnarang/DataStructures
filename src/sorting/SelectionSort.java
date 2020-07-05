package sorting;

/*
 * 
 * Selection Sort 
 * 
 * Sorts an array by repeatedly finding the minimum element (considering ascending order) 
 * from unsorted part and putting it at the beginning. 
 * The algorithm maintains two subarrays in a given array.
 * 
 * arr[] = 64 25 12 22 11
 * sorted arr[] = 11 12 22 25 64
 * 
 */

public class SelectionSort {
	
	public static void main(String[] args) {
		int[] arr = {64, 25, 12, 22, 11};
		System.out.println("Before Sorting : ");
		printArray(arr);
		sort(arr);
		System.out.print("\n\n");
		System.out.println("After Sorting : ");
		printArray(arr);
	}

	private static void printArray(int[] arr) {
		for(int i = 0 ; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	private static void sort(int[] arr) {
		for(int i = 0 ; i < arr.length - 1; i++) {
			int minIndex = i; 
			for(int j = i + 1 ; j < arr.length; j++) {
				if(arr[j] < arr[minIndex])
					minIndex = j;
			}
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
	}

}
