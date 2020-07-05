package recursion;


/*
 * Print all subsets using recursion and print lexicographically
 * I/P :[1,2,3]
 * O/P:[[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class SubsetProb {
	
	public static Set<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<Integer> aux = new ArrayList<>();
        Set<ArrayList<Integer>> result = new LinkedHashSet<ArrayList<Integer>>();
        Collections.sort(A);
        generate(0,A,aux,result);
        return result;
    }
    public static void generate(int index, ArrayList<Integer> A, ArrayList<Integer> aux, Set<ArrayList<Integer>> result){
         result.add(new ArrayList<>(aux));
         for(int i = index; i < A.size(); i++){
             aux.add(A.get(i));
             generate(i+1,A,aux,result);
             aux.remove(aux.size()-1);
         }
    }
    
    public static void main(String[] args) {
		ArrayList<Integer> arr= new ArrayList<Integer>();
		arr.add(1);
		arr.add(2);
		arr.add(2);
		System.out.println(subsets(arr));
	}

}
