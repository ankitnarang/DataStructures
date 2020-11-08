package arrays;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {

    public static void main(String[] args) {
        int[] stones = {2,7,4,1,8,1};
        System.out.println("The last stone weight is " + lastStoneWeight(stones));
    }

    private static int lastStoneWeight(int[] stones){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for(int stone : stones){
            maxHeap.add(stone);
        }

        while(maxHeap.size() > 1){
            int stoneOne = maxHeap.remove();
            int stoneTwo = maxHeap.remove();
            if(stoneOne != stoneTwo){
                maxHeap.add((stoneOne - stoneTwo));
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.remove();
    }

}
