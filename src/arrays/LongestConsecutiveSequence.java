package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * 
 * Longest Consecutive Sequence
 * Given [100, 4, 200, 1, 3, 2], 
 * The longest consecutive elements sequence is [1, 2, 3, 4]. 
 * Return its length: 4
 * 
 */

public class LongestConsecutiveSequence {
	
	private static int longestConsecutive(final List<Integer> A) {
        Set<Integer> set = new HashSet<>();
        int length = 0;
        for(int i = 0 ; i < A.size(); i++){
            set.add(A.get(i));
        }
        for(int i = 0 ; i < A.size(); i++){
            if(!set.contains(A.get(i)-1)){
                int x = A.get(i);
                while(set.contains(x))
                    x++;
                length = Math.max(length,(x- A.get(i)));    
            }
        }
        return length;
    }
	
	public static void main(String[] args) {
		List<Integer> A = new ArrayList<Integer>(Arrays.asList(100, 4, 200, 1, 3, 2));
		System.out.println(longestConsecutive(A));
	}

}
