package backtracking;

import java.util.*;

public class SubsetII {
    private static Set<ArrayList<Integer>> result;
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1,1,3));
        result = new LinkedHashSet<>();
        ArrayList<Integer> aux = new ArrayList<>();
        Collections.sort(nums);
        generateSubset(0,nums,aux,result);
        result.forEach((x) -> System.out.println(x));
    }

    private static void generateSubset(int index, ArrayList<Integer> nums, ArrayList<Integer> aux, Set<ArrayList<Integer>> result) {
        result.add(new ArrayList<Integer>(aux));
        for(int i = index; i < nums.size(); i++){
            aux.add(nums.get(i));
            generateSubset(i+1,nums,aux,result);
            aux.remove(aux.size()-1);
        }
    }
}
