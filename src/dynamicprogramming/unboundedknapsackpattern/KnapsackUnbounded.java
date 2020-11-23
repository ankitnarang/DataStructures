package dynamicprogramming.unboundedknapsackpattern;

public class KnapsackUnbounded {
    // Question Link : https://www.geeksforgeeks.org/unbounded-knapsack-repetition-items-allowed/
    // Reference Link :
    public static void main(String[] args) {
        int[] weight = {5, 10, 15};
        int[] value = {10, 30, 20};
        int W = 100;
        int n = weight.length;
        int result = unboundedKnapsackRecursive(W,n,value,weight);
        System.out.println("The result of max value is " + result);
        result = unboundedKnapsackIterative(W,n,value,weight);
        System.out.println("The result of max value is " + result);
    }

    private static int unboundedKnapsackRecursive(int W, int n, int[] value, int[] weight) {
        if(W == 0 || n == 0){
            return 0;
        }
        if(weight[n-1] < W){
            return unboundedKnapsackRecursive(W,n-1,value,weight) +
                    unboundedKnapsackRecursive(W - weight[n-1],n,value,weight);
        } else {
            return unboundedKnapsackRecursive(W,n-1,value,weight);
        }
    }

    private static int unboundedKnapsackIterative(int W, int n, int[] value, int[] weight){
        int dp[] = new int[W+1];
        for(int i = 0 ; i < W + 1; i++){
            for(int j = 0; j < n; j++){
                if(weight[j] <= i ){
                    dp[i] = Math.max(dp[i],dp[i - weight[j]] + value[j]);
                }
            }
        }

        return dp[W];
    }

}
