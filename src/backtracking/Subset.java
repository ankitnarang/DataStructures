package backtracking;

import java.util.ArrayList;

public class Subset {
    private static ArrayList<ArrayList<Integer>> result;
    public static void main(String[] args) {
        result = new ArrayList<ArrayList<Integer>>();
        int[] nums = {1,2,3};
        generateSubset(0,nums,new ArrayList<Integer>(),result);
        result.forEach((x) -> System.out.println(x));
    }

    private static void generateSubset(int index, int[] nums, ArrayList<Integer> current,
                                       ArrayList<ArrayList<Integer>> result){
        result.add(new ArrayList<>(current));
        for(int i = index; i < nums.length; i++){
            current.add(nums[i]);
            generateSubset(i+1,nums,current,result);
            current.remove(current.size()-1);
        }
    }

}
