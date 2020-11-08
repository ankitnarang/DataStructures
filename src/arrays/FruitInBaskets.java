package arrays;

import java.util.HashMap;
import java.util.Map;

public class FruitInBaskets {
    public static void main(String[] args) {
        int[] trees = {3,3,3,1,2,1,1,2,3,3,4};
        int result = totalFruit(trees);
        System.out.println("No of fruits collected is " + result);
    }

    private static int totalFruit(int[] trees){

        if(trees == null || trees.length == 0){
            return 0;
        }

        int max = 1;
        int i = 0;
        int j = 0;
        Map<Integer,Integer> map = new HashMap<>();

        while (j < trees.length) {
            if(map.size() <= 2){
                map.put(trees[j],j++);
            }
            if(map.size() > 2){
                int min = trees.length - 1;
                for(int value : map.values()){
                    min = Math.min(min,value);
                }
                i = min + 1;
                map.remove(trees[min]);
            }

            max = Math.max(max,j - i);
        }

        return max;
    }

}
