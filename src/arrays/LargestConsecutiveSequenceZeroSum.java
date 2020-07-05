package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * Largest Continuous Sequence Zero Sum
 * Input:  {1 ,2 ,-2 ,4 ,-4}
 * Output: {2 ,-2 ,4 ,-4}
 */

public class LargestConsecutiveSequenceZeroSum {
	
	private static ArrayList<Integer> lszero(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Map<Integer,Integer> map = new HashMap<>();
        int start = -1;
        int end = -1;
        int maxLength = -1;
        int sum = 0;
        map.put(0,-1);
        for(int i = 0 ; i < A.size(); i++){
            sum += A.get(i);
            if(map.containsKey(sum)){
                if(maxLength < (i - map.get(sum))){
                    start = map.get(sum) + 1;
                    end = i;
                    maxLength = i - map.get(sum);
                }
            } else {
                map.put(sum,i);
            }
        }
        if(start >= 0 && end >= 0){
            for(int i = start; i <= end; i++){
                result.add(A.get(i));
            }
        }
        return result;
    }
	
	public static void main(String[] args) {
		//ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1,2,0,4,5));
		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1,2,-2,4,-4));
		System.out.println(lszero(A));
	}

}
