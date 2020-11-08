package arrays;

import java.util.HashSet;
import java.util.Set;

public class InterserctionOfTwoArrays {

    public static void main(String[] args) {
        int[] nums1 = {4,9,5}; //{1,2,2,1};
        int[] nums2 = {9,4,9,8,4}; //{2,2};

        int[] result = intersection(nums1,nums2);

        System.out.println("Intersection of 2 arrays are ");
        for(int num : result){
            System.out.print(num + " ");
        }

    }

    private static int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set = new HashSet<>();
        Set<Integer> intersection = new HashSet<>();

        for(int num : nums1){
            set.add(num);
        }

        for (int num : nums2){
            if(set.contains(num)){
                intersection.add(num);
            }
        }

        int[] result = new int[intersection.size()];
        int index = 0;
        for (int num : intersection){
            result[index++] = num;
        }

        return result;
    }

}
