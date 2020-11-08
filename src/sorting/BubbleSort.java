package sorting;

/*
 * 
 * Bubble Sort 
 * 
 * Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements
 * if they are in wrong order.
 * 
 * arr[] = 64 25 12 22 11
 * sorted arr[] = 11 12 22 25 64
 * 
 */

public class BubbleSort {
	public static void main(String[] args) {
		int[] arr = {64, 25, 12, 22, 11};
		System.out.println("Before Sorting : ");
		printArray(arr);
		sort(arr);
		System.out.print("\n\n");
		System.out.println("After Sorting : ");
		printArray(arr);
	}

	private static void sort(int[] arr) {
		for(int i = 0 ; i < arr.length - 1; i++) {
			for(int j = 0 ; j < arr.length - 1 - i; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}

	private static void printArray(int[] arr) {
		for(int i = 0 ; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
