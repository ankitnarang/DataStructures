package arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MissingNumbers {
    public static void main(String[] args) {
        int[] nums = {5,3,2,6,4,2,3,1};
        List<Integer> numbers = findMissingNumbers(nums);
        numbers.forEach((x) -> System.out.print(x + " "));
    }

    private static List<Integer> findMissingNumbers(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<>();
        Set<Integer> numbers = new HashSet<>();

        for(int num : nums){
            numbers.add(num);
        }

        for(int i = 1; i <= nums.length; i++){
            if(!numbers.contains(i)){
                missingNumbers.add(i);
            }
        }

        return missingNumbers;
    }
}
