package math;

import java.util.PriorityQueue;

public class KClosestPointToOrigin {
    public static void main(String[] args) {
        int[][] points = {
                {1,3},
                {-2,2},
        };
        int K = 1;
        System.out.println("Result is : \n");
        int[][] result = KClosest(points, K);
        for(int i = 0; i < result.length; i++){
            for(int j = 0; j < result[0].length; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] KClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> (b[0] * b[0] + b[1] * b[1] -
                a[0] * a[0] + a[1] * a[1]));

        for(int[] point : points){
            maxHeap.add(point);
            if(maxHeap.size() > k){
                maxHeap.remove();
            }
        }

        int[][] result = new int[k][2];

        while(k-- > 0){
            result[k] = maxHeap.remove();
        }

        return result;
    }
}
