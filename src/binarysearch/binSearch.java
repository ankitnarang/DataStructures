package binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class binSearch {
	
	private static int search(List<Integer> list,int key, int low, int high) {
		if(low<=high) {
			int mid = low + (high-low)/2;
			//System.out.println(mid + " " + list.get(mid));
			if(list.get(mid).equals(key)) {
				return mid;
			} else if (list.get(mid) < key) {
				//low = mid + 1;
				return search(list, key, mid + 1, high);
			} else {
				//high = mid -1;
				return search(list, key, low, mid -1);
			}
		} 
		return -1;
	}
	
	private static int returnCount(List<Integer> list,int key) {
		//System.out.println(list);
		int index = search(list,key,0,list.size()-1);
		int prev = index, next = index, count = 1;
		if(prev != 0) {
			while(prev>=0 && list.get(prev).equals(list.get(prev-1))) {
				count++;
				prev--;
			}
		}
		if(next != list.size() - 1) {
			while(next <= list.size()-1  && list.get(next).equals(list.get(next+1))) {
				count++;
				next++;
			}
		}
		
		//System.out.println(index);
		return count;
	}
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>(Arrays.asList(1,4,4,4,4,6,6,6,7,8,10,10));
		int key = 10;
		System.out.println(list);
		System.out.println(returnCount(list, key));
		
	}

}
