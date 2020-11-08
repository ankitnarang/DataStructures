package heap;

import java.util.PriorityQueue;

public class KthLargestElement {
    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,7,5,6};
        int k = 2;
        int result = findKthLargest(nums,k);
        System.out.println("Result is " + result);
    }

    private static int findKthLargest(int[] nums, int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i : nums){
            minHeap.add(i);
            if(minHeap.size() > k){
                minHeap.remove();
            }
        }
        return minHeap.remove();
    }

}
