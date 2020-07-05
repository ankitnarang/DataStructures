package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * 
 * Find if there is a sub-array with 0 sum
 * 	
  	Input: A = [1, 2, 3, 4, 5]
	Output: 0
    Input : A = [5, 17, -22, 11]
	Output : 1
 */

public class SubArrayWithSumZero {
	
	private static int solve(ArrayList<Integer> A) {
        if(A == null || A.isEmpty())
            return 0;
        if(A.size() == 1 && A.get(0) == 0)
        	return 1;
        Map<Long,Integer> map = new HashMap<>();
        Long sum = 0L;
        for(int i = 0 ; i < A.size(); i++ ){
            if(A.get(i) == 0)
                return 1;
            sum += A.get(i);
            if(sum == 0)
                return 1;
            if(map.get(sum) != null)
                return 1;
            map.put(sum,i);
        }
        return 0;
    }
	
	public static void main(String[] args) {
		//ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(5,17,-22,11));
		System.out.println(solve(A));
	}

}
