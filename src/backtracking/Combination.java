package backtracking;

import java.util.*;

public class Combination {
    private static  Set<ArrayList<Integer>> result;
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(7,2,6,3));
        int sum = 7;
        result = new LinkedHashSet<ArrayList<Integer>>();
        ArrayList<Integer> aux = new ArrayList<>();
        Collections.sort(nums);
        generate(0,nums,sum,aux,result);
        result.forEach((x) -> System.out.println(x));
    }

    private static void generate(int index, ArrayList<Integer> nums, int sum,
                                 ArrayList<Integer> aux, Set<ArrayList<Integer>> result){

        if((index >= nums.size()) || sum < 0){
            return;
        }
        if((sum == 0)){
            result.add(aux);
            return;
        }

        ArrayList<Integer> temp = new ArrayList<>(aux);
        temp.add(nums.get(index));
        generate(index,nums,sum-nums.get(index),temp,result); // include element
        generate(index+1,nums,sum,aux,result); // exclude element
    }

}
