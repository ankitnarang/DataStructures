package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * 
 * Insertion Sort 
 * 
 * arr[] = 64 25 12 22 11
 * sorted arr[] = 11 12 22 25 64
 * 
 */

public class InsertionSort {
	
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
		for(int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int j = i - 1;
			while(j >= 0 && arr[j] > key) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
		}
	}

	private static void printArray(int[] arr) {
		for(int i = 0 ; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	

}
