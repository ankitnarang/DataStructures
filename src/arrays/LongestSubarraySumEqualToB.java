package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * Given an array of integers A of size N and an integer B.
 * Find the length of longest subarray having sum equal to B.
 * Input A = [1, 2, 3, 4, 5] and B = 10
 * Output : 4
 * 
 */

public class LongestSubarraySumEqualToB {
	
	private static int solve(ArrayList<Integer> A, int B) {
        Map<Long,Integer> map = new HashMap<>();
        long sum = 0;
        int maxLength = -1;
        for(int i = 0 ; i < A.size(); i++){
            sum += A.get(i);
            if(sum == B){
                maxLength = i + 1;
            }
            if(!map.containsKey(sum))
                map.put(sum,i);
            if(map.containsKey(sum - B)){
                maxLength = Math.max(maxLength,i-map.get(sum-B));
            }
        }
        return maxLength;
    }

	public static void main(String[] args) {
		//ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1,1,-1,-1));
		int B = 0;
		System.out.println(solve(A, B));
	}

}
