package arrays;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = {2,2,1,1,1,2}; // {2,2,1,1,1,2,2} // {3,2,3}
        int result = majorityElem(arr);
        if(result != -1){
            System.out.println("Result of majority element in arrays is " + result);
        } else {
            System.out.println("No majority element in array");
        }

    }

    private static int majorityElem(int[] arr){
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : arr){
            if(map.containsKey(num) && (map.get(num) + 1) > (arr.length/2) ){
                return num;
            } else {
                map.put(num,map.getOrDefault(num,0) + 1);
            }
        }
        return -1;
    }

}
