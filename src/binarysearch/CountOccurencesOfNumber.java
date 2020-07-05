package binarysearch;

import java.util.ArrayList;
import java.util.Arrays;

public class CountOccurencesOfNumber {
	
	private static int count(ArrayList<Integer> arrList,int key) {
		int low = 0;
		int high = arrList.size()-1;
		
		int first = lowerBound(arrList,low,high,key);
		
		if(first == -1)
			return first;
		
		int last = upperBound(arrList,first,high,key);
		
		return last - first + 1;
	}
	
	
	
	private static int upperBound(ArrayList<Integer> arrList, int low, int high, int key) {
		while(low <= high) {
			int mid = low + (high-low)/2;
			if((mid == arrList.size()-1 || arrList.get(mid+1) > key) && arrList.get(mid) == key)
				return mid;
			else if (arrList.get(mid) > key)
				return upperBound(arrList, low, mid - 1, key);
			else 
				return upperBound(arrList, mid + 1, high, key);
		}
		return -1;
	}



	private static int lowerBound(ArrayList<Integer> arrList, int low, int high, int key) {
		while(low <= high) {
			int mid = low + (high-low)/2;
			if((mid == 0 || arrList.get(mid-1) < key) && arrList.get(mid) == key)
				return mid;
			else if (arrList.get(mid) < key)
				return lowerBound(arrList, mid+1, high, key);
			else 
				return lowerBound(arrList, low, mid-1, key);
		}
		return -1;
	}



	public static void main(String[] args) {
		ArrayList<Integer> arrList = 
				new ArrayList<Integer>(Arrays.asList(1, 2, 2, 3, 3, 3, 3));
		int key = 1;
		int count = count(arrList,key);
		if(count == -1)
			System.out.println("Key " + key  + " not found!!");
		else 
			System.out.println("Key " + key  + " was found " + count + " no of times in given array");
	}
	

}
