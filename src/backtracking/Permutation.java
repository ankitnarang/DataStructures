package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Permutation {
    private static List<List<Integer>> result;
    public static void main(String[] args) {
        result = new ArrayList<>();
        int[] nums = {2,1,3};
        Arrays.sort(nums);
        generatePermutation(0,nums,result);
        result.forEach((x) -> System.out.println(x));
    }

    private static void generatePermutation(int start, int[] nums,List<List<Integer>> result) {
        ArrayList<Integer> list = new ArrayList<>();
        if(start == nums.length){
            for(int num : nums){
                list.add(num);
            }
            result.add(list);
            return;
        }
        for(int i = start; i< nums.length; i++){
            swap(nums,i,start);
            generatePermutation(start+1,nums,result);
            swap(nums,i,start);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
