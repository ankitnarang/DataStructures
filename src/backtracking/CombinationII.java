package backtracking;

import java.util.*;

public class CombinationII {
    private static  Set<ArrayList<Integer>> result;
    public static void main(String[] args) {

        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(10, 1, 2, 7, 6, 1, 5));
        int sum = 8;
        /*
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(2,5,2,1,2));
        int sum = 5;
         */
        result = new LinkedHashSet<>();
        ArrayList<Integer> aux = new ArrayList<>();
        Collections.sort(nums);
        generateCombination(0,nums,sum,aux,result);
        result.forEach((x) -> System.out.println(x));
    }

    private static void generateCombination(int index, ArrayList<Integer> nums, int sum,
                                 ArrayList<Integer> aux, Set<ArrayList<Integer>> result){
        if((sum == 0)){
            result.add(new ArrayList<>(aux));
            return;
        }
        if((index >= nums.size())) {
            return;
        }
        if(sum < 0){
            return;
        }
        for(int i = index; i < nums.size(); i++){
            aux.add(nums.get(i));
            generateCombination(i+1,nums,sum-nums.get(i),aux,result);
            aux.remove(aux.size()-1);
        }
    }

}
