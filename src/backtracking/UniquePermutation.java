package backtracking;

import java.util.*;

public class UniquePermutation {
    public static void main(String[] args) {
        Set<ArrayList<Integer>> result = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2));
        Collections.sort(list);
        int left = 0;
        int right = list.size() - 1;
        permute(list, left,right, result);
        result.forEach((x) -> System.out.println(x));
    }

    private static void permute(ArrayList<Integer> list, int left, int right, Set<ArrayList<Integer>> result) {
        if(left == right){
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i  = left; i <= right; i++){
            swap(list,left,i);
            permute(list,left+1,right,result);
            swap(list,left,i);
        }

    }

    private static void swap(ArrayList<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i,list.get(j));
        list.set(j,temp);
    }

}
