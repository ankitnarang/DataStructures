package binarysearch;

import java.util.ArrayList;

/*
 * 
 * Single Element in a Sorted Array appear once and rest all appear twice.
 * I/P : [1, 1, 2, 2, 3]
 * O/P : 3
 * I/P : [5, 11, 11, 100, 100]
 * O/P : 5
 */

public class SingleElement {
	
	public static int solve(ArrayList<Integer> A) {
        int low = 0;
        int high = A.size()-1;
        return search(A,low,high);
    }
    public static int search(ArrayList<Integer> A, int low, int high){
        if(low>high)
            return -1;
        if(low == high){
            return A.get(low);
        }
        //int mid = low + ((high - low)/2);
        int mid = (low+high)/2;
        if(mid%2 == 0){
            if(A.get(mid).equals(A.get(mid+1))){
                return search(A,mid+2,high);
            }
            else {
                return search(A,low,mid);
            }
        }
        else if(mid%2 == 1){
            if(A.get(mid).equals(A.get(mid-1))){
                return search(A,mid+1,high);
            }
            else {
                return search(A,low,mid-1);
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		// [ 106, 106, 248, 248, 286, 286, 344, 357, 357 ]
		arr.add(106);
		arr.add(106);
		arr.add(248);
		arr.add(248);
		arr.add(286);
		arr.add(286);
		arr.add(344);
		arr.add(357);
		arr.add(357);
		System.out.println(solve(arr));
	}
}
