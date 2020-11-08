package heap;

import java.util.ArrayList;
import java.util.Arrays;

public class BuildHeap {
	
	public static void main(String[] args) {
		ArrayList<Integer> arrList = 
				new ArrayList<Integer>(Arrays.asList(1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17 ));
		int len = arrList.size();
		
		System.out.println("------------------\nBuilding Max Heap\n------------------\n");
		System.out.println("Original Array :"); 
		arrList.forEach((elem) -> System.out.print(elem + " "));
		
		buildMaxHeap(arrList,len);
		System.out.println();
		printHeap(arrList,len);
		
		arrList = new ArrayList<Integer>(Arrays.asList(10, 3, 15, 4, 16, 13, 1, 19, 8, 5, 7 ));
		
		System.out.println("\n\n------------------");
		System.out.println("Building Min Heap\n------------------\n");
		System.out.println("Original Array :"); 
		arrList.forEach((elem) -> System.out.print(elem + " "));
		
		buildMinHeap(arrList,len);
		System.out.println();
		printHeap(arrList,len);
		
	}

	private static void printHeap(ArrayList<Integer> arrList, int len) {
		System.out.println("Array representation of Heap is:"); 
		arrList.forEach((elem) -> System.out.print(elem + " "));
	}

	private static void buildMaxHeap(ArrayList<Integer> arrList, int len) {
		int startIndex = (len/2) - 1;
		
		for(int i = startIndex; i >= 0; i--) {
			maxHeapify(arrList,len,i);
		}
	}

	private static void maxHeapify(ArrayList<Integer> arrList, int len, int i) {
		int largest = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		
		if(l < len && arrList.get(l) > arrList.get(largest)) {
			largest = l;
		}
		
		if(r < len && arrList.get(r) > arrList.get(largest)) {
			largest = r;
		}
		
		if(largest != i) {
			int swap = arrList.get(i);
			arrList.set(i, arrList.get(largest));
			arrList.set(largest, swap);
			maxHeapify(arrList, len, largest);
		}
		
	}
	
	private static void buildMinHeap(ArrayList<Integer> arrList, int len) {
		int startIndex = (len/2) - 1;
		
		for(int i = startIndex; i >= 0; i--) {
			minHeapify(arrList,len,i);
		}
	}

	private static void minHeapify(ArrayList<Integer> arrList, int len, int i) {
		int smallest = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		
		if(l < len && arrList.get(l) < arrList.get(smallest)) {
			smallest = l;
		}
		
		if(r < len && arrList.get(r) < arrList.get(smallest)) {
			smallest = r;
		}
		
		if(smallest != i) {
			int swap = arrList.get(i);
			arrList.set(i, arrList.get(smallest));
			arrList.set(smallest, swap);
			minHeapify(arrList, len, smallest);
		}
		
	}
	
}
