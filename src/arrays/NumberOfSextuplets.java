package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class NumberOfSextuplets {
	
	private static int solve(ArrayList<Integer> A) {
        int index = 0;
        int len = A.size();
        int temp = (len*len*len)+1;
        int[] RHS = new int[temp];
        Arrays.fill(RHS, 0);
        for(int i = 0 ; i < len; i++){
            if(A.get(i) != 0){
                for(int j = 0 ; j < len; j++){
                    for(int k = 0 ; k < len; k++){
                        RHS[index] = ((A.get(j) + A.get(k)) * A.get(i));
                        index++;
                    }
                }
            }
        }
        Arrays.sort(RHS);
        int result = 0;
        for(int i = 0 ; i < len; i++){
            if(A.get(i) != 0){
                for(int j = 0 ; j < len; j++){
                    for(int k = 0 ; k < len; k++){
                        int value = (A.get(i)*A.get(j)) + A.get(k);
                        result = result + (upperBound(RHS,index,value) - lowerBound(RHS,index,value));
                    }
                }
            }
        }
        return result;
    }
    private static int upperBound(int[] array, int length, int key){
        int low = 0;
        int high = length;
        while(low < high){
            int mid = low + (high-low)/2;
            if(key >= array[mid])
                low = mid + 1;
            else 
                high = mid;
        }
        return low;
    }
    private static int lowerBound(int[] array, int length, int key){
        int low = 0;
        int high = length;
        while(low < high){
            int mid = low + (high-low)/2;
            if(key <= array[mid])
                high = mid;
            else 
                low = mid+1;
        }
        return low;
    }
    
    public static void main(String[] args) {
		ArrayList<Integer> arrList = new ArrayList<Integer>(Arrays.asList(2,3));
		System.out.println(solve(arrList));
	}

}
