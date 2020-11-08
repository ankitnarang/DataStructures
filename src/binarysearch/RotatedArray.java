package binarysearch;

/*
 * 
 * Search an element in a sorted and rotated array
 * Input  : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
 * key = 3
 * Output : Found at index 8
 * 
 */

public class RotatedArray {
	
	public static void main(String[] args) {
		int arr[] = {4, 5, 6, 7, 8, 9, 1, 2, 3}; 
		int key = 4;
		int index = search(arr,0,arr.length-1,key);
		if(index == -1)
			System.out.println(key + " not found in given array.");
		else
			System.out.println(key  + " is found at index " + index);
	}

	private static int search(int[] arr, int low, int high, int key) {
		if(low>high)
			return -1;
		int mid = low + (high-low)/2;
		if(arr[mid] == key)
			return mid;
		if(arr[low] <= arr[mid]) {
			if(key >= arr[low] && arr[mid] >= key)
				return search(arr, low, mid-1, key);
			else
				return search(arr, mid+1, high, key);
		}
		if(key >= arr[mid] && key <= arr[high])
			return search(arr, mid+1, high, key);
		else
			return search(arr, low, mid-1, key);
		
	}

}
