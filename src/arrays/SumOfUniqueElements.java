package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * 
 * Find unique elements sum in array in O(n) time where
 * unique elements considered are the elements 
 * which are not repeated more than once in array
 * 
 * Example : Array : [5,8,4,1,5,9,4,5,1,4,4,4,5,5,5,14]
 * Unique elements will be : 8,9,14
 */

public class SumOfUniqueElements {
	
	private static int solve(ArrayList<Integer> arrList) {
		int sum = 0;
		Map<Integer,Integer> map = new HashMap<>();
		for(int i = 0; i < arrList.size(); i++) {
			sum += arrList.get(i);
			if(!map.containsKey(arrList.get(i))) {
				map.put(arrList.get(i), 1);
			} 
			else if(map.containsKey(arrList.get(i)) && map.get(arrList.get(i)) >= 1) {
				if (map.containsKey(arrList.get(i)) && map.get(arrList.get(i)) > 1) {
					sum = sum - arrList.get(i);
				} else if (map.containsKey(arrList.get(i)) && map.get(arrList.get(i)) == 1) {
					sum = sum - (2*arrList.get(i));
				}
				map.put( arrList.get(i), map.get(arrList.get(i))+1 );
			}
		}
		return sum;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> arrList = new ArrayList<Integer>(Arrays.asList(5,8,4,1,5,9,4,5,1,4,4,4,5,5,5,14,1,2,2,90));
		System.out.println(solve(arrList));
	}

}
